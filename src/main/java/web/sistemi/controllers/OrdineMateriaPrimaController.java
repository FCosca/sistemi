package web.sistemi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.sistemi.entities.OrdineMateriaPrima;
import web.sistemi.services.OrdineMateriaPrimaService;

@RestController
public class OrdineMateriaPrimaController {

    @Autowired
    private OrdineMateriaPrimaService ordineMateriaPrimaService;

    @GetMapping("/OrdineMateriaPrima")
    public ResponseEntity getAll(){
        return new ResponseEntity<>(ordineMateriaPrimaService.allOrdine(), HttpStatus.OK);
    }//getAll

    @PostMapping("/OrdineMateriPrima/add")
    public ResponseEntity create (@RequestBody OrdineMateriaPrima ordineMateriaPrima){
        OrdineMateriaPrima oMP = null;
        oMP = ordineMateriaPrimaService.addOrdine(ordineMateriaPrima);
        return new ResponseEntity<>(oMP, HttpStatus.OK);
    }
}
