package web.sistemi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.sistemi.entities.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

    Member findByEmail(String email);

}