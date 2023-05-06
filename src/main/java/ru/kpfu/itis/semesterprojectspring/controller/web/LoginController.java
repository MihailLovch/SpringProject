package ru.kpfu.itis.semesterprojectspring.controller.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.semesterprojectspring.model.dto.UserLoginForm;

@Controller
@AllArgsConstructor
public class LoginController {
    @GetMapping("/login")
    public String loginInit(ModelMap map) {
        map.addAttribute("userForm", new UserLoginForm());
        return "login";
    }
}
