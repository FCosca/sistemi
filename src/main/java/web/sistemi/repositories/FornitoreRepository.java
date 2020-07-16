package web.sistemi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import web.sistemi.entities.Fornitore;


import java.util.List;

public interface FornitoreRepository extends JpaRepository<Fornitore, String> {
    
    @Override
    List<Fornitore> findAll();

    Fornitore findFornitoreByPIVA(String PIVA);


    List<Fornitore> findByNome(String nome);

    List<Fornitore> findBySede(String sede);
    
    boolean existsByPIVA(String PIVA);
    

}//FornitoreRepository
