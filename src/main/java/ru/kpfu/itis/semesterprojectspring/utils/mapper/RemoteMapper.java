package ru.kpfu.itis.semesterprojectspring.utils.mapper;

import ru.kpfu.itis.semesterprojectspring.model.dto.RandomRecipeDto;
import ru.kpfu.itis.semesterprojectspring.remote.apiresponse.RecipeResponse;

public class RemoteMapper {
    private static final String FATS = "Fat";
    private static final String CARBS = "Carbohydrates";
    private static final String CALORIES = "Calories";

    public static RandomRecipeDto mapToRandomRecipeDto(RecipeResponse recipeResponse) {

        return RandomRecipeDto.builder()
                .calories(recipeResponse.getNutrition().getNutrients().stream().filter(it -> it.getName().equals(CALORIES)).findFirst().orElseThrow(()->new IllegalArgumentException("Not found")).getAmount())
                .carbs(recipeResponse.getNutrition().getNutrients().stream().filter(it -> it.getName().equals(CARBS)).findFirst().orElseThrow(()->new IllegalArgumentException("Not found")).getAmount())
                .fats(recipeResponse.getNutrition().getNutrients().stream().filter(it -> it.getName().equals(FATS)).findFirst().orElseThrow(()->new IllegalArgumentException("Not found")).getAmount())
                .description(recipeResponse.getSummary())
                .instruction(recipeResponse.getInstructions())
                .imageUrl(recipeResponse.getImage())
                .build();
    }
}
