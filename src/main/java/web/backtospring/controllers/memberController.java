package web.backtospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.backtospring.entities.Member;
import web.backtospring.repositories.MemberRepository;
import web.backtospring.services.MemberService;

import javax.validation.Valid;

@Controller
public class memberController {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/login")
    public String showLoginForm(){
        return "views/loginForm";
    }


    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("member", new Member());
        return "views/registerForm";
    }
    @PostMapping("/register")
    public String registerMember(@Valid Member member, Model model){
        String email = member.getEmail();
        if (memberRepository.findByEmail(email) != null){
            model.addAttribute("exist",true);
            return "views/registerForm";
        }
        memberService.createMember(member);
        model.addAttribute("success", true);
        return "views/loginForm";
    }
}
