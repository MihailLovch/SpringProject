package ru.kpfu.itis.semesterprojectspring.utils.mapper;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.semesterprojectspring.model.dto.EditedUserForm;
import ru.kpfu.itis.semesterprojectspring.model.dto.UserDashboardDto;
import ru.kpfu.itis.semesterprojectspring.model.dto.UserLoginForm;
import ru.kpfu.itis.semesterprojectspring.model.dto.UserSignupForm;
import ru.kpfu.itis.semesterprojectspring.model.entity.Record;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;
import ru.kpfu.itis.semesterprojectspring.utils.calories.CaloriesUtil;
import ru.kpfu.itis.semesterprojectspring.utils.date.DateExtension;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

@AllArgsConstructor
@Component
public class UserMapper {

    private PasswordEncoder passwordEncoder;

    public UserDashboardDto mapToUserDashboard(User user) {
        return UserDashboardDto.builder()
                .maxCalories(CaloriesUtil.calcMaxCalories(user))
                .maxProteins(CaloriesUtil.calcMaxProteins(user))
                .maxCarb(CaloriesUtil.calcMaxCarbs(user))
                .maxFat(CaloriesUtil.calcMaxFats(user))
                .record(user.getRecords().stream()
                        .filter(it -> DateExtension.checkDatesTheSameDay(Calendar.getInstance().getTime(), it.getDate()))
                        .findFirst()
                        .orElse(Record.builder()
                                .calorie(0d)
                                .proteins(0d)
                                .fat(0d)
                                .carb(0d)
                                .build()))
                .build();
    }

    public User mapToUser(UserSignupForm form) {
        return User.builder()
                .name(form.getNickName())
                .password(passwordEncoder.encode(form.getPassword()))
                .email(form.getEmail())
                .weight(form.getWeight())
                .height(form.getHeight())
                .age(form.getAge())
                .sex(form.getSex())
                .preferredRecipes(Collections.emptyList())
                .build();
    }

}
