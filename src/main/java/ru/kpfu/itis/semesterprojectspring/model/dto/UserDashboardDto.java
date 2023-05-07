package ru.kpfu.itis.semesterprojectspring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.semesterprojectspring.model.entity.Record;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDashboardDto {
    private Double maxCalories;
    private Double maxProteins;
    private Double maxFat;
    private Double maxCarb;
    private Record record;
}
