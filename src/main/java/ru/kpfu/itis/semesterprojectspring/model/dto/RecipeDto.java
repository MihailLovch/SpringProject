package ru.kpfu.itis.semesterprojectspring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeDto {

    private String name;
    private Double calories;
    private Double proteins;
    private Double fat;
    private Double carbs;
}
