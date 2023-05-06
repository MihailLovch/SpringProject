package ru.kpfu.itis.semesterprojectspring.controller.rest;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.semesterprojectspring.exception.IllegalRecipeException;
import ru.kpfu.itis.semesterprojectspring.model.entity.Recipe;
import ru.kpfu.itis.semesterprojectspring.model.response.my.DataResponse;
import ru.kpfu.itis.semesterprojectspring.model.response.my.DefaultResponse;
import ru.kpfu.itis.semesterprojectspring.service.RecipeService;

@RestController
@RequestMapping("/api/recipes")
@AllArgsConstructor
public class RecipeRestController {

    private final String ADD_SUCCESS = "Added recipe successfully";
    private final String UPDATE_SUCCESS = "Recipe updated successfully";
    private final String DELETE_SUCCESS = "Recipe deleted successfully";

    private RecipeService recipeService;

    @PostMapping("/add")
    public ResponseEntity<?> addRecipe(@RequestBody Recipe recipe){
        try{
            recipeService.saveRecipe(recipe);
            return ResponseEntity.ok(new DefaultResponse(ADD_SUCCESS));
        }catch (IllegalRecipeException ex){
            return new ResponseEntity<>(new DefaultResponse(ex.getMessage()),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(new DataResponse<>(recipeService.getAll()));
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try{
            Recipe recipe = recipeService.getById(id);
            return ResponseEntity.ok(new DataResponse<>(recipe));
        }catch (EntityNotFoundException ex){
            return new ResponseEntity<>(new DefaultResponse(ex.getMessage()),HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}/name")
    public ResponseEntity<?> updateRecipeName(@PathVariable Long id, @RequestParam String newName){
        try{
            Recipe recipe = recipeService.getById(id);
            recipe.setName(newName);
            recipeService.saveRecipe(recipe);
            return ResponseEntity.ok(new DefaultResponse(UPDATE_SUCCESS));
        }catch (EntityNotFoundException ex){
            return new ResponseEntity<>(new DefaultResponse(ex.getMessage()),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable Long id){
        try{
            recipeService.deleteRecipe(id);
            return ResponseEntity.ok(new DefaultResponse(DELETE_SUCCESS));
        }catch (IllegalRecipeException ex){
            return new ResponseEntity<>(new DefaultResponse(ex.getMessage()),HttpStatus.CONFLICT);
        }
    }
}
