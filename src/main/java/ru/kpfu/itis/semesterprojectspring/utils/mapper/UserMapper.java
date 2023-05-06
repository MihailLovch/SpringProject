package ru.kpfu.itis.semesterprojectspring.utils.mapper;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.semesterprojectspring.model.dto.UserLoginForm;
import ru.kpfu.itis.semesterprojectspring.model.dto.UserSigningForm;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;

import java.util.Collections;

@AllArgsConstructor
@Component
public class UserMapper {

    private PasswordEncoder passwordEncoder;

    public User mapToUser(UserSigningForm form){
        System.out.println("form: "  + form.getPassword() + "  encode: " + passwordEncoder.encode(form.getPassword()));
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

    public User mapToUser(UserLoginForm form){
        System.out.println("form: " + form.getPassword() + "  encode: " + passwordEncoder.encode(form.getPassword()));
        return User.builder()
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .build();
    }
}
