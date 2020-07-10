package web.sistemi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.sistemi.entities.MateriaPrima;
import web.sistemi.repositories.MateriaPrimaRepository;

import java.util.List;

@Service
public class MateriaPrimaService {

    @Autowired
    MateriaPrimaRepository materiaPrimaRepository;

    @Transactional(readOnly = true)
    public List<MateriaPrima> allMateriaPrima() { return materiaPrimaRepository.findAll();}

    @Transactional(readOnly = true)
    public MateriaPrima getByCodice(String Codice){
        return materiaPrimaRepository.findMateriaPrimaByCodice(Codice);
    }//getByCodice
}
