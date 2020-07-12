package web.sistemi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.sistemi.entities.MateriaPrima;
import web.sistemi.repositories.MateriaPrimaRepository;
import web.sistemi.supporto.MateriaPrimaInesistenteException;

import java.util.List;

@Service
public class MateriaPrimaService {

    @Autowired
    MateriaPrimaRepository materiaPrimaRepository;

    @Transactional(readOnly = true)
    public List<MateriaPrima> allMateriaPrima() { return materiaPrimaRepository.findAll();}

    
    //Ho aggiunto un'eccezione, crea la classe con lo stesso nome(come fatto per l'altra eccezione) nel package supporto e poi fa import qui.
    //Inoltre aggiungi nel repository di materia prima l'existsByCodice(String codice)
    //Se non vuoi l'eccezione lascia tutto come prima
    @Transactional(readOnly = true)
    public MateriaPrima getByCodice(int Codice) throws MateriaPrimaInesistenteException {
        if(!(materiaPrimaRepository.existsByCodice(Codice))){
            throw new MateriaPrimaInesistenteException();
        }//if
        return materiaPrimaRepository.findMateriaPrimaByCodice(Codice);
    }//getByCodice
}
