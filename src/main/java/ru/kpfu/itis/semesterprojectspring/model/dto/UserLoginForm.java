package ru.kpfu.itis.semesterprojectspring.model.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginForm {
    @Size(min = 8,max = 40)
    private String email;
    @Size(min = 8,max = 40)
    private String password;
}
