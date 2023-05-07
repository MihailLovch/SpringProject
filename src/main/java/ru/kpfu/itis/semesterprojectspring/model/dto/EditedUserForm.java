package ru.kpfu.itis.semesterprojectspring.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditedUserForm {
    @NotEmpty
    private String name;
    @Range(min = 50, max = 360)
    private Integer weight;
    @Range(min = 120, max = 220)
    private Integer height;
    @Range(min = 0, max = 120)
    private Integer age;
    @NotNull(message = "Should be filled")
    private Boolean sex;
}
