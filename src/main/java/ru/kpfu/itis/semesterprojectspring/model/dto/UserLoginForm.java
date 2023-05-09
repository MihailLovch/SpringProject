package ru.kpfu.itis.semesterprojectspring.model.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginForm {
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]{8,40}@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Not appropriate email")
    @Email
    private String email;
    @Size(min = 6,max = 40)
    private String password;
}
