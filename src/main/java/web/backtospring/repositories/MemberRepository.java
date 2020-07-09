package web.backtospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.backtospring.entities.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

    Member findByEmail(String email);

}