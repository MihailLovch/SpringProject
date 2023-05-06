package ru.kpfu.itis.semesterprojectspring.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {
    @RequestMapping("/home")
    public String list(ModelMap map) {
        return "mainpage";
    }
}
