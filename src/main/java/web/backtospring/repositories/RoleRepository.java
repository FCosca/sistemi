package web.backtospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.backtospring.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}