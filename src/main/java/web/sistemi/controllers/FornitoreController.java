package web.sistemi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import web.sistemi.services.FornitoreService;

@Controller
public class FornitoreController {

    @Autowired
    private FornitoreService fornitoreService;

    @GetMapping("/fornitori")
    public ResponseEntity getAll() {
        return new ResponseEntity<>(fornitoreService.allFornitore(), HttpStatus.OK);
    }//getAll

    @GetMapping("/fornitori/{PIVA}")
    public ResponseEntity getByPiva(@PathVariable("PIVA") String PIVA){
        Fornitore fornitore = fornitoreService.getByPIva(PIVA);
        if(fornitore == null){
            return new ResponseEntity<>("Nessun risultato!",HttpStatus.OK);
        }//if
        return new ResponseEntity<>(fornitore, HttpStatus.OK);
    }//getByPiva

    @PostMapping("/fornitori")
    public ResponseEntity create(@RequestBody Fornitore fornitore) throws PIVAGiaEsistenteException{
        Fornitore f = null;
        try{
            f = fornitoreService.addFornitore(fornitore);
        }catch(PIVAGiaEsistenteException e){
            return new ResponseEntity<>("PIVA già esistente", HttpStaus.BAD_REQUEST);
        }//try
        return new ResponseEntity<>(f, HttpStatus.OK);
    }//create
    
}//FornitoreController
