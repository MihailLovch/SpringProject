package ru.kpfu.itis.semesterprojectspring.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    @GetMapping("/logout")
    public String logout(){
        return "redirect:/login?logout";
    }
}
