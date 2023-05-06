package ru.kpfu.itis.semesterprojectspring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RandomRecipeDto {
    private Double calories;
    private Double carbs;
    private Double fats;
    private String imageUrl;
    private String information;
    private String instruction;
}
