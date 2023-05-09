package ru.kpfu.itis.semesterprojectspring.controller.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.semesterprojectspring.model.dto.UserDashboardDto;
import ru.kpfu.itis.semesterprojectspring.model.entity.Record;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;
import ru.kpfu.itis.semesterprojectspring.service.RecordService;
import ru.kpfu.itis.semesterprojectspring.service.UserService;
import ru.kpfu.itis.semesterprojectspring.utils.mapper.UserMapper;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class DashboardController {

    private final UserMapper userMapper;
    private final UserService userService;
    private final RecordService recordService;
    @GetMapping("/dashboard")
    public String view(
            ModelMap map,
            Principal principal
    ){
        User user = userService.findUserByEmail(principal.getName());
        UserDashboardDto userDashboardDto = userMapper.mapToUserDashboard(user);
        int countDate = recordService.countDaysWhenOverCalories(user,userDashboardDto);
        Calendar calendar= Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,-30);
        List<Record> records = recordService.findRecordsByUserAndDateRange(user,calendar.getTime(),Calendar.getInstance().getTime());

        map.addAttribute("dashboard",userDashboardDto);
        map.addAttribute("countDays",countDate);
        map.addAttribute("records",records);
        return "dashboard";
    }
}
