package web.sistemi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.sistemi.entities.Fornitore;
import web.sistemi.repositories.FornitoreRepository;
import web.sistemi.supporto.PivaGiaEsistenteException;

import java.util.List;

@Service
public class FornitoreService {

    @Autowired
    FornitoreRepository fornitoreRepository;

    @Transactional(readOnly = true)
    public List<Fornitore> allFornitore() { return fornitoreRepository.findAll();}

    @Transactional(readOnly = true)
    public Fornitore getByPIva(String pIva){
        return fornitoreRepository.findFornitoreByPIVA(pIva);
    }//getByPIva




    @Transactional
    public Fornitore addFornitore(Fornitore fornitore) throws PivaGiaEsistenteException {
        if(fornitoreRepository.existsByPIVA(fornitore.getPIVA())){
            throw new PivaGiaEsistenteException();
        }//if
        return fornitoreRepository.save(fornitore);
    }//addFornitore

}//FornitoreService
