package ru.kpfu.itis.semesterprojectspring.controller.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;
import ru.kpfu.itis.semesterprojectspring.service.UserService;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class MyProfileController {

    private final UserService userService;

    @GetMapping("/profile")
    public String view(Principal principal, ModelMap map){

        User user = userService.findUserByEmail(principal.getName());
        map.addAttribute("user",user);
        return "profile";
    }

    @PostMapping("/profile")
    public String deleteProfile(
            Principal principal
    ){
//        userService.deleteUser(userService.findUserByEmail(principal.getName()));
        System.out.println("TEST-TAG DELETED");
        return "redirect:/logout";
    }
}
