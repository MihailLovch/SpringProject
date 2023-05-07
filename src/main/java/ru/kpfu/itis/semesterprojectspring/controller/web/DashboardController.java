package ru.kpfu.itis.semesterprojectspring.controller.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.semesterprojectspring.service.UserService;
import ru.kpfu.itis.semesterprojectspring.utils.mapper.UserMapper;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class DashboardController {

    private final UserMapper userMapper;
    private final UserService userService;

    @GetMapping("/dashboard")
    public String view(
            ModelMap map,
            Principal principal
    ){
        map.addAttribute("dashboard",userMapper.mapToUserDashboard(userService.findUserByEmail(principal.getName())));
        return "dashboard";
    }
}
