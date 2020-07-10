package web.backtospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.backtospring.entities.Fornitore;

import java.util.List;

public interface FornitoreRepository extends JpaRepository<Fornitore, String> {
    @Override
    List<Fornitore> findAll();
}
