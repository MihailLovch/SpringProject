package ru.kpfu.itis.semesterprojectspring.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSigningForm {
    @NotEmpty
    private String nickName;

    @Size(min = 6, max = 20)
    private String password;

    @Email
    @Size(max = 100)
    private String email;
    @Range(min = 50,max = 360)
    private int weight;
    @Range(min = 120, max = 220)
    private int height;

    @Range(min = 0,max = 120)
    private int age;

    @NotNull(message = "Не должно быть пустым")
    private Boolean sex;
}
