package ru.kpfu.itis.semesterprojectspring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecordDto {
    private Double calorie;
    private Double carb;
    private Double fat;
    private Double protein;
}
