package ru.kpfu.itis.semesterprojectspring.controller.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.semesterprojectspring.model.dto.RecordDto;
import ru.kpfu.itis.semesterprojectspring.model.entity.Training;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;
import ru.kpfu.itis.semesterprojectspring.service.TrainingService;
import ru.kpfu.itis.semesterprojectspring.service.UserService;

import java.security.Principal;

@Controller
@AllArgsConstructor
@RequestMapping("/trainings")
public class TrainingController {

    private final UserService userService;
    private final TrainingService trainingService;

    @GetMapping("/list")
    public String view(
            ModelMap map,
            Principal principal
    ){
        if (principal != null){
            map.addAttribute("user",userService.findUserByEmail(principal.getName()));
        }
        map.addAttribute("trainings",trainingService.getAll());
        return "training";
    }

    @GetMapping("/train")
    public String train(
            ModelMap map,
            Principal principal,
            @RequestParam Long trainingId,
            @RequestParam Integer minutes
    ){
        if (!(minutes >= 1 && minutes <= 60)){
            map.addAttribute("error","Minutes should be between 1 and 60");
            return view(map, principal);
        }
        User user = userService.findUserByEmail(principal.getName());
        Training training = trainingService.findById(trainingId);
        userService.updateUserRecord(user,new RecordDto(-training.getCalories()*minutes,0d,0d,0d));
        return "redirect:/trainings/list";
    }
}
