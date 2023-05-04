
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
public class RecipeResponse {
    @SerializedName("nutrition")
    private Nutrition nutrition;
    @SerializedName("summary")
    private String summary;
    @SerializedName("image")
    private String image;
    @SerializedName("instructions")
    private String instructions;
}
