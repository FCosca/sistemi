package web.sistemi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import web.sistemi.entities.OrdineMateriaPrima;

import java.util.List;

public interface OrdineMateriaPrimaRepository extends JpaRepository<OrdineMateriaPrima, String> {

    @Override
    List<OrdineMateriaPrima> findAll();



}
