package ru.kpfu.itis.semesterprojectspring.service.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.semesterprojectspring.exception.IllegalRecipeException;
import ru.kpfu.itis.semesterprojectspring.model.entity.Recipe;
import ru.kpfu.itis.semesterprojectspring.repository.RecipeRepository;
import ru.kpfu.itis.semesterprojectspring.service.RecipeService;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    private RecipeRepository recipeRepository;

    @Override
    public void saveRecipe(Recipe recipe) {
        try {
            recipeRepository.save(recipe);
        } catch (Exception ex) {
            throw new IllegalRecipeException(ex.getMessage());
        }
    }

    @Override
    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No recipe with id:" + id));
    }

    @Override
    public void deleteRecipe(Long id) {
        try{
            recipeRepository.deleteById(id);
        }catch (Exception ex){
            throw new IllegalRecipeException(ex.getMessage());
        }
    }
}
