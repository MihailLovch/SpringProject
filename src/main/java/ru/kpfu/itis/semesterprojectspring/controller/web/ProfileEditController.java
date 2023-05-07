package ru.kpfu.itis.semesterprojectspring.controller.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.semesterprojectspring.model.dto.EditedUserForm;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;
import ru.kpfu.itis.semesterprojectspring.service.UserService;
import ru.kpfu.itis.semesterprojectspring.utils.mapper.UserMapper;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class ProfileEditController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/profile/edit")
    public String view(ModelMap map, Principal principal){
        map.addAttribute("user",userService.findUserByEmail(principal.getName()));
        map.addAttribute("editedUserForm",new EditedUserForm());
        return "profileEdit";
    }

    @PostMapping("/profile/edit")
    public String submitChanges(
            ModelMap map,
            @ModelAttribute @Validated EditedUserForm form,
            BindingResult result,
            Principal principal
            ){
        if (result.hasErrors()){
            map.addAttribute("notice","All fields should be completed");
            map.addAttribute("user",userService.findUserByEmail(principal.getName()));
            return "redirect:/profile/edit";
        }
        User user = userService.findUserByEmail(principal.getName());
        user.setAge(form.getAge());
        user.setWeight(form.getWeight());
        user.setHeight(form.getHeight());
        user.setSex(form.getSex());
        user.setName(form.getName());
        userService.updateUser(user);
        return "redirect:/profile";
    }
}
