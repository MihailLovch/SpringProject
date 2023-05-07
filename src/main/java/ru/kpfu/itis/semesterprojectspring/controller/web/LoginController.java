package ru.kpfu.itis.semesterprojectspring.controller.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.semesterprojectspring.model.dto.UserLoginForm;

@Controller
@AllArgsConstructor
public class LoginController {
    @GetMapping("/login")
    public String loginInit(ModelMap map, @RequestParam Boolean error) {
        map.addAttribute("userForm", new UserLoginForm());
        if (error != null){
            map.addAttribute("errorMessage","Incorrect email or password");
        }
        return "login";
    }
}
