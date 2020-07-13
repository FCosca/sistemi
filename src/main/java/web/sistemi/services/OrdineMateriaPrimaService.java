package web.sistemi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import web.sistemi.entities.OrdineMateriaPrima;
import web.sistemi.repositories.OrdineMateriaPrimaRepository;

import java.util.List;

@Service
public class OrdineMateriaPrimaService {

    @Autowired
    OrdineMateriaPrimaRepository ordineMateriaPrimaRepository;

    @Transactional(readOnly = true)
    public List<OrdineMateriaPrima> allOrdine(){return ordineMateriaPrimaRepository.findAll();}

    @Transactional
    public OrdineMateriaPrima addOrdine(OrdineMateriaPrima ordineMateriaPrima){
        return ordineMateriaPrimaRepository.save(ordineMateriaPrima);
    }

}
