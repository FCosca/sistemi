package web.backtospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.backtospring.entities.Fornitore;

public interface FornitoreRepository extends JpaRepository<Fornitore, String> {
}
