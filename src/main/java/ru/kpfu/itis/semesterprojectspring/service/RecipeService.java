package ru.kpfu.itis.semesterprojectspring.service;

import ru.kpfu.itis.semesterprojectspring.model.entity.Recipe;

import java.util.List;

public interface RecipeService {
    void saveRecipe(Recipe recipe);
    List<Recipe> getAll();

    Recipe getById(Long id);

    void deleteRecipe(Long id);
}
