package web.sistemi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.sistemi.entities.Fornitore;
import web.sistemi.services.FornitoreService;
import web.sistemi.supporto.PivaGiaEsistenteException;

@Controller
public class FornitoreController {

    @Autowired
    private FornitoreService fornitoreService;

    @RequestMapping("/fornitori")
    public ResponseEntity getAll() {
        return new ResponseEntity<>(fornitoreService.allFornitore(), HttpStatus.OK);
    }//getAll

    @RequestMapping("/fornitori/{PIVA}")
    public ResponseEntity getByPiva(@PathVariable("PIVA") String PIVA){
        Fornitore fornitore = fornitoreService.getByPIva(PIVA);
        if(fornitore == null){
            return new ResponseEntity<>("Nessun risultato!",HttpStatus.OK);
        }//if
        return new ResponseEntity<>(fornitore, HttpStatus.OK);
    }//getByPiva

    @RequestMapping("/fornitori/{nome}")
    public ResponseEntity getByNome(@PathVariable("Nome") String Nome){
        Fornitore fornitore = fornitoreService.getByNome(Nome);
        if(fornitore == null){
            return new ResponseEntity<>("Nessun risultato!",HttpStatus.OK);
        }//if
        return new ResponseEntity<>(fornitore, HttpStatus.OK);
    }//getByNome

    @RequestMapping("/fornitori/{sede}")
    public ResponseEntity getBySede(@PathVariable("sede") String sede){
        Fornitore fornitore = fornitoreService.getBySede(sede);
        if(fornitore == null){
            return new ResponseEntity<>("Nessun risultato!",HttpStatus.OK);
        }//if
        return new ResponseEntity<>(fornitore, HttpStatus.OK);
    }//getBySede


    @PostMapping("/fornitori")
    public ResponseEntity create(@RequestBody Fornitore fornitore) throws PivaGiaEsistenteException{
        Fornitore f = null;
        try{
            f = fornitoreService.addFornitore(fornitore);
        }catch(PivaGiaEsistenteException e){
            return new ResponseEntity<>("PIVA già esistente", HttpStatus.BAD_REQUEST);
        }//try
        return new ResponseEntity<>(f, HttpStatus.OK);
    }//create
    
}//FornitoreController
