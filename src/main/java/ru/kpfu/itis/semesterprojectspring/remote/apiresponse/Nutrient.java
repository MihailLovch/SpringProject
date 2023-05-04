
package ru.kpfu.itis.semesterprojectspring.remote.apiresponse;

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

