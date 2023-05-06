
package ru.kpfu.itis.semesterprojectspring.model.response.api;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nutrition {
    @SerializedName("nutrients")
    private List<Nutrient> nutrients;

}
