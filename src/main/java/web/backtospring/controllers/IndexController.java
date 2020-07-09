package web.backtospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.backtospring.entities.Member;
import web.backtospring.repositories.MemberRepository;

import java.security.Principal;
import java.sql.SQLOutput;
import java.util.Date;

@Controller
public class IndexController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/")
    public String showIndex(Model model, Principal principal, Member member){
        if(principal == null){
            return "views/loginForm";
        }
        model.addAttribute("message", "Hello everyone, we are go to back to Spring with together");
        model.addAttribute("date", new Date());
        model.addAttribute("members", memberRepository.getOne(principal.getName()));
        return "index";
    }
}