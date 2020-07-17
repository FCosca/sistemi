package web.sistemi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.sistemi.entities.Fornitore;
import web.sistemi.services.FornitoreService;
import web.sistemi.supporto.PivaGiaEsistenteException;
import web.sistemi.supporto.PivaNonEsiste;

import java.util.List;

@RestController
public class FornitoreController {

    @Autowired
    private FornitoreService fornitoreService;


    @GetMapping("/fornitori")
    public ResponseEntity getAll() {
        return new ResponseEntity<>(fornitoreService.allFornitore(), HttpStatus.OK);
    }//getAll

    @GetMapping("/fornitori/{PIVA}")
    public ResponseEntity getByPiva(@PathVariable("PIVA") String PIVA) {
        Fornitore fornitore = fornitoreService.getByPIva(PIVA);
        if (fornitore == null) {
            return new ResponseEntity<>("Nessun risultato!", HttpStatus.OK);
        }//if
        return new ResponseEntity<>(fornitore, HttpStatus.OK);
    }//getByPiva

  /*  @GetMapping("/fornitori/{PIVA}")
    public ModelAndView getByPiva(@PathVariable("PIVA") String PIVA) {
        Fornitore fornitore = fornitoreService.getByPIva(PIVA);
        if (fornitore == null) {
            return new ModelAndView("Nessun risultato!", HttpStatus.OK);
        }//if
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/fornitori/");
        return mv;

    }//getByPiva
*/
    @GetMapping("/fornitori/bynome/{nome}")
    public ResponseEntity getByNome(@PathVariable("nome") String nome) {
        List<Fornitore> fornitori = fornitoreService.getByNome(nome);
        if (fornitori.size() == 0) {
            return new ResponseEntity<>("Nessun risultato!", HttpStatus.OK);
        }//if
        return new ResponseEntity<>(fornitori, HttpStatus.OK);
    }//getByNome

    @GetMapping("/fornitori/bysede/{sede}")
    public ResponseEntity getBySede(@PathVariable("sede") String sede) {
        List<Fornitore> fornitori = fornitoreService.getBySede(sede);
        if (fornitori.size() == 0) {
            return new ResponseEntity<>("Nessun risultato!", HttpStatus.OK);
        }//if
        return new ResponseEntity<>(fornitori, HttpStatus.OK);
    }//getBySede


    @PostMapping("/fornitori/add")
    public ResponseEntity create(@RequestBody Fornitore fornitore) throws PivaGiaEsistenteException {
        Fornitore f = null;
        try {
            f = fornitoreService.addFornitore(fornitore);
        } catch (PivaGiaEsistenteException e) {
            return new ResponseEntity<>("PIVA già esistente", HttpStatus.BAD_REQUEST);
        }//try
        return new ResponseEntity<>(f, HttpStatus.OK);
    }//create


    @DeleteMapping("/fornitori/delete/{pIva}")
    public ResponseEntity delete(
//            non serve l'oggetto fornitore in caso di delete ma ci si basa sull'id di solito
//            @RequestBody Fornitore fornitore
            @PathVariable("pIva") String pIva) {
        try {
            fornitoreService.deleteFornitore(pIva);
        } catch (PivaNonEsiste e) {
            return new ResponseEntity<>("impossibile eliminarlo ", HttpStatus.BAD_REQUEST); //TODO per le eccezioni é meglio usare un global exception handler per uniformare il tutto
        }
        return new ResponseEntity<String>("elimintato", HttpStatus.OK); //TODO in genere si restituisce in output un json non una string raw


    }


}//FornitoreController
