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
import ru.kpfu.itis.semesterprojectspring.model.dto.UserSigningForm;
import ru.kpfu.itis.semesterprojectspring.service.UserService;
import ru.kpfu.itis.semesterprojectspring.utils.mapper.UserMapper;

@Controller
@AllArgsConstructor
public class SigningController {

    private UserService userService;
    private UserMapper userMapper;

    @GetMapping("/sign-in")
    public String showSignIn(ModelMap map){
        map.addAttribute("signingForm", new UserSigningForm());
        return "registration";
    }

    @PostMapping("/sign-in")
    public String signIn(
            ModelMap map,
            @Validated @ModelAttribute("signingForm") UserSigningForm userSigningForm,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            return "registration";
        }
        try {
            userService.signInUser(userMapper.mapToUser(userSigningForm));
            return "redirect:/home";//TODO(): change to cabinet
        }catch (IllegalUserException exception){
            map.addAttribute("errorMessage",exception.getMessage());
            return "registration";
        }
    }

}
