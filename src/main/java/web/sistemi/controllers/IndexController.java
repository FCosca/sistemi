package web.sistemi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import web.sistemi.entities.Fornitore;
import web.sistemi.entities.MateriaPrima;
import web.sistemi.entities.Member;
import web.sistemi.repositories.MemberRepository;
import web.sistemi.services.MemberService;

import java.security.Principal;
import java.util.Date;

@Controller
public class IndexController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/")
    public String showIndex(Model model, Principal principal, Member member, Fornitore fornitore, MateriaPrima materiaPrima){
        if(principal == null){
            return "views/loginForm";
        }
        model.addAttribute("message", "Hello everyone, we are go to back to Spring with together");
        model.addAttribute("date", new Date());
        model.addAttribute("members", memberRepository.getOne(principal.getName()));

   /*     Member a= new Member("12@gmail.com", "11@gmail.com");

        if(a.getEmail().equals("11@gmail.com") )
            return "Direttore";
        else
            return "Responsabile"; */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
     if(currentPrincipalName.equals("12@gmail.com"))
         return "Direttore";
     else
         return "Responsabile";

    }


}