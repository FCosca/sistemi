package web.sistemi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.sistemi.entities.Fornitore;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public interface FornitoreRepository extends JpaRepository<Fornitore, String> {
    
    @Override
    List<Fornitore> findAll();
    
    Fornitore findFornitoreByPIVA(String PIVA);
    
    boolean existsByPIVA(String PIVA);
    

}//FornitoreRepository
