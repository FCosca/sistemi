package web.sistemi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.sistemi.entities.Fornitore;
import web.sistemi.services.FornitoreService;
import web.sistemi.supporto.PivaGiaEsistenteException;
import web.sistemi.supporto.PivaNonEsiste;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping("/fornitori/bynome/{nome}")
    public ResponseEntity getByNome(@PathVariable("nome") String nome){
        List<Fornitore> fornitori = fornitoreService.getByNome(nome);
        if(fornitori.size() == 0){
            return new ResponseEntity<>("Nessun risultato!",HttpStatus.OK);
        }//if
        return new ResponseEntity<>(fornitori, HttpStatus.OK);
    }//getByNome

    @RequestMapping("/fornitori/bysede/{sede}")
    public ResponseEntity getBySede(@PathVariable("sede") String sede){
        List<Fornitore> fornitori = fornitoreService.getBySede(sede);
        if(fornitori.size() == 0){
            return new ResponseEntity<>("Nessun risultato!",HttpStatus.OK);
        }//if
        return new ResponseEntity<>(fornitori, HttpStatus.OK);
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



    @DeleteMapping("/fornitori/delete/{PIVA}")
    public ResponseEntity delete(@RequestBody Fornitore fornitore) throws PivaNonEsiste {
        Fornitore f = null;
        try{
            f = fornitoreService.deleteFornitore(fornitore);
        }catch (PivaNonEsiste e){
            return new ResponseEntity<>( "impossibile eliminarlo ", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(f, HttpStatus.OK);


    }


    
}//FornitoreController
