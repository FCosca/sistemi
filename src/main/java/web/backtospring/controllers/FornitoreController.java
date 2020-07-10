package web.backtospring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import web.backtospring.services.FornitoreService;

@Controller
public class FornitoreController {

    @Autowired
    private FornitoreService fornitoreService;

    @GetMapping("/Fornitore")
    public ResponseEntity getAll() {
        return new ResponseEntity<>(fornitoreService.allFornitore(), HttpStatus.OK);
    }
}
