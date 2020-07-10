package web.backtospring.services;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.backtospring.entities.Fornitore;
import web.backtospring.repositories.FornitoreRepository;

import java.util.List;

@Service
public class FornitoreService {

    @Autowired
    FornitoreRepository fornitoreRepository;

    @Transactional(readOnly = true)
    public List<Fornitore> allFornitore() { return fornitoreRepository.findAll();}

}
