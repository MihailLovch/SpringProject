package ru.kpfu.itis.semesterprojectspring.controller.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.semesterprojectspring.exception.IllegalUserException;
import ru.kpfu.itis.semesterprojectspring.model.dto.UserLoginForm;
import ru.kpfu.itis.semesterprojectspring.service.UserService;
import ru.kpfu.itis.semesterprojectspring.utils.mapper.UserMapper;

@Controller
@AllArgsConstructor
public class LoginController {

    private UserService userService;
    private UserMapper userMapper;

    @GetMapping("/login")
    public String loginInit(ModelMap map) {
        map.addAttribute("logged", true);
        map.addAttribute("userForm", new UserLoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @Validated @ModelAttribute("userForm") UserLoginForm userForm,
            BindingResult bindingResult,
            ModelMap map
    ) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        try{
            userService.loginUser(userMapper.mapToUser(userForm));
            return "redirect:/home"; //TODO(): redicrect to cabinet
        }catch (IllegalUserException ex){
            map.addAttribute("errorMessage",ex.getMessage());
            return "login";
        }
    }
}
