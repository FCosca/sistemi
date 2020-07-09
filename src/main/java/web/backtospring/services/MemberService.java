package web.backtospring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import web.backtospring.entities.Member;
import web.backtospring.entities.Role;
import web.backtospring.repositories.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(Member member){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        member.setPassword(encoder.encode(member.getPassword()));
        Role memberRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(memberRole);
        member.setRole(roles);
        memberRepository.save(member);
        return member;
    }
}
