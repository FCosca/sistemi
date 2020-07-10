package web.sistemi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.sistemi.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}