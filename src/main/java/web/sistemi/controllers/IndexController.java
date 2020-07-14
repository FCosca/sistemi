package web.sistemi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.sistemi.entities.Fornitore;
import web.sistemi.entities.Member;
import web.sistemi.repositories.MemberRepository;

import java.security.Principal;
import java.util.Date;

@Controller
public class IndexController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/")
    public String showIndex(Model model, Principal principal, Member member, Fornitore fornitore){
        if(principal == null){
            return "views/loginForm";
        }
        model.addAttribute("message", "Hello everyone, we are go to back to Spring with together");
        model.addAttribute("date", new Date());
        model.addAttribute("members", memberRepository.getOne(principal.getName()));

        return "index";
    }
}