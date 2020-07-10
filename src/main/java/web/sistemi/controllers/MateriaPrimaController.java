package web.sistemi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.sistemi.entities.Fornitore;
import web.sistemi.entities.MateriaPrima;
import web.sistemi.services.MateriaPrimaService;

@Controller
public class MateriaPrimaController {

    @Autowired
    private MateriaPrimaService materiaPrimaService;

    @RequestMapping("/materiaPrima")
    public ResponseEntity getAll() {
        return new ResponseEntity<>(materiaPrimaService.allMateriaPrima(), HttpStatus.OK);
    }//getAll

    @RequestMapping("/materiaPrima/{Codice}")
    public ResponseEntity getByCodice(@PathVariable("Codice") String Codice){
        MateriaPrima materiaPrima = materiaPrimaService.getByCodice(Codice);
        if(materiaPrima == null){
            return new ResponseEntity<>("Nessun Risultato!", HttpStatus.OK);
        }
        return new ResponseEntity<>(materiaPrima, HttpStatus.OK);
    }//getByCodice



}
