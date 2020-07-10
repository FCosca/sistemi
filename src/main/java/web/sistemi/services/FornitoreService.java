package web.sistemi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.sistemi.entities.Fornitore;
import web.sistemi.repositories.FornitoreRepository;

import java.util.List;

@Service
public class FornitoreService {

    @Autowired
    FornitoreRepository fornitoreRepository;

    @Transactional(readOnly = true)
    public List<Fornitore> allFornitore() { return fornitoreRepository.findAll();}

//    @Transactional(readOnly = true)
 //   public List<Fornitore> allFornitore(String PIVA){ return fornitoreRepository.findAll();}

//    @Transactional(readOnly = true)
//    public List<Fornitore> allFornitore(String nome){return fornitoreRepository.findAll();}




    @Transactional(readOnly = false)
    public void AddFornitore(String PIVA, String nome, String sede){

    }

}
