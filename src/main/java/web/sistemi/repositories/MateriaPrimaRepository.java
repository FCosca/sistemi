package web.sistemi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.sistemi.entities.MateriaPrima;

import java.util.List;

public interface MateriaPrimaRepository extends JpaRepository<MateriaPrima, Integer> {

    @Override
    List<MateriaPrima> findAll();

    MateriaPrima findMateriaPrimaByCodice(int codice);

    boolean existsByCodice(int codice);
}

