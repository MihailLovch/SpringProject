package ru.kpfu.itis.semesterprojectspring.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSignupForm {
    @NotEmpty
    private String nickName;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}$", message = "Should contain one small and upper letter, one number, one spec symbol and be from 6 to 20")
    @Size(min = 6, max = 20)
    private String password;

    @Email
    @Size(max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]{8,40}@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Not appropriate email")
    private String email;
    @Range(min = 50,max = 360)
    private int weight;
    @Range(min = 120, max = 220)
    private int height;

    @Range(min = 0,max = 120)
    private int age;

    @NotNull(message = "Should be filled")
    private Boolean sex;
}
