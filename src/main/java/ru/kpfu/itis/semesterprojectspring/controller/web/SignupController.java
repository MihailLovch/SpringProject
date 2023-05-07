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
import ru.kpfu.itis.semesterprojectspring.model.dto.UserSignupForm;
import ru.kpfu.itis.semesterprojectspring.service.UserService;
import ru.kpfu.itis.semesterprojectspring.utils.mapper.UserMapper;

@Controller
@AllArgsConstructor
public class SignupController {

    private UserService userService;
    private UserMapper userMapper;

    @GetMapping("/sign-up")
    public String view(ModelMap map){
        map.addAttribute("signupForm", new UserSignupForm());
        return "registration";
    }

    @PostMapping("/sign-up")
    public String signUp(
            ModelMap map,
            @Validated @ModelAttribute("signupForm") UserSignupForm userSignupForm,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            return "registration";
        }
        try {
            userService.signInUser(userMapper.mapToUser(userSignupForm));
            return "redirect:/profile";
        }catch (IllegalUserException exception){
            map.addAttribute("errorMessage",exception.getMessage());
            return "registration";
        }
    }

}
