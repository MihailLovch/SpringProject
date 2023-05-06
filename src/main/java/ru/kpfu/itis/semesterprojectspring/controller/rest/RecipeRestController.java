package ru.kpfu.itis.semesterprojectspring.controller.rest;

import io.swagger.annotations.*;
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
@Api(tags = "Recipe Controller")
public class RecipeRestController {

    private static final String ADD_SUCCESS = "Added recipe successfully";
    private static final String UPDATE_SUCCESS = "Recipe updated successfully";
    private static final String DELETE_SUCCESS = "Recipe deleted successfully";

    private RecipeService recipeService;

    @ApiOperation(value = "Add new recipe")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ADD_SUCCESS),
            @ApiResponse(code = 404, message = "Error adding recipe")
    })
    @PostMapping("/add")
    public ResponseEntity<?> addRecipe(
            @ApiParam(value = "Recipe object", required = true) @RequestBody Recipe recipe
    ) {
        try {
            recipeService.saveRecipe(recipe);
            return ResponseEntity.ok(new DefaultResponse(ADD_SUCCESS));
        } catch (IllegalRecipeException ex) {
            return new ResponseEntity<>(new DefaultResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get all recipes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All recipes")
    })
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(new DataResponse<>(recipeService.getAll()));
    }

    @ApiOperation(value = "Get recipe by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Recipe found"),
            @ApiResponse(code = 404, message = "Recipe not found")
    })
    @GetMapping("/info/{id}")
    public ResponseEntity<?> getById(
            @ApiParam(value = "Recipe id", required = true) @PathVariable Long id
    ) {
        try {
            Recipe recipe = recipeService.getById(id);
            return ResponseEntity.ok(new DataResponse<>(recipe));
        } catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(new DefaultResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Update recipe by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Recipe updated"),
            @ApiResponse(code = 404, message = "Recipe not found")
    })
    @PutMapping("/{id}/name")
    public ResponseEntity<?> updateRecipeName(
            @ApiParam(value = "Recipe id", required = true) @PathVariable Long id,
            @ApiParam(value = "New recipe name", required = true) @RequestParam String newName
    ) {
        try {
            Recipe recipe = recipeService.getById(id);
            recipe.setName(newName);
            recipeService.saveRecipe(recipe);
            return ResponseEntity.ok(new DefaultResponse(UPDATE_SUCCESS));
        } catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(new DefaultResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Delete recipe by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Recipe deleted"),
            @ApiResponse(code = 404, message = "Recipe not found")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRecipe(
            @ApiParam(value = "Recipe id", required = true) @PathVariable Long id
    ) {
        try {
            recipeService.deleteRecipe(id);
            return ResponseEntity.ok(new DefaultResponse(DELETE_SUCCESS));
        } catch (IllegalRecipeException ex) {
            return new ResponseEntity<>(new DefaultResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
