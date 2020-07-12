package web.sistemi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.sistemi.entities.MateriaPrima;
import web.sistemi.services.MateriaPrimaService;
import web.sistemi.supporto.MateriaPrimaInesistenteException;


@Controller
public class MateriaPrimaController {

    @Autowired
    private MateriaPrimaService materiaPrimaService;

    @RequestMapping("/materiaPrima")
    public ResponseEntity getAll() {
        return new ResponseEntity<>(materiaPrimaService.allMateriaPrima(), HttpStatus.OK);
    }//getAll

    //Se vuoi gestirlo cosi va bene, se invece vuoi lanciare un'eccezione vedi controller nel quale lo abbiamo fatto
    //Nota: i nomi delle variabili vanno scritte in minuscolo
    @RequestMapping("/materiaPrima/{codice}")
    public ResponseEntity getByCodice(@PathVariable("codice") int codice) throws MateriaPrimaInesistenteException{
        MateriaPrima materiaPrima = null;
        try{
            materiaPrima = materiaPrimaService.getByCodice(codice);
        }catch(MateriaPrimaInesistenteException e){
            return new ResponseEntity<>("MateriaPrima inesistente", HttpStatus.BAD_REQUEST);
        }//try
        return new ResponseEntity<>(materiaPrima, HttpStatus.OK);
    }//getByCodice



}


