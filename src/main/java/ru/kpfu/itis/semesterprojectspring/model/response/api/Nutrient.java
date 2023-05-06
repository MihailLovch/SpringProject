
package ru.kpfu.itis.semesterprojectspring.model.response.api;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nutrient {
    @SerializedName("amount")
    private Double amount;
    @SerializedName("name")
    private String name;
}

