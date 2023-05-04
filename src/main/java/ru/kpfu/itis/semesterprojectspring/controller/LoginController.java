package ru.kpfu.itis.semesterprojectspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.semesterprojectspring.model.dto.UserLoginForm;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginInit(ModelMap map) {
        map.addAttribute("logged", true);
        map.addAttribute("userForm", new UserLoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @Validated @ModelAttribute("userForm") UserLoginForm userForm,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        return "redirect:/home";
    }
}
