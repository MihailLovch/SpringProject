package ru.kpfu.itis.semesterprojectspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.semesterprojectspring.model.dto.UserSigningForm;

@Controller
public class SigningController {

    @GetMapping("/sign-in")
    public String showSignIn(ModelMap map){
        map.addAttribute("signingForm", new UserSigningForm());
        return "registration";
    }

    @PostMapping("/sign-in")
    public String signIn(
            @Validated @ModelAttribute("signingForm") UserSigningForm userSigningForm,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            return "registration";
        }
        return "redirect:/home";
    }

}
