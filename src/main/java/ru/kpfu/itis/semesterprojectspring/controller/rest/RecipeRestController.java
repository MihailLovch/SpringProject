package ru.kpfu.itis.semesterprojectspring.controller.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.semesterprojectspring.exception.IllegalRecipeException;
import ru.kpfu.itis.semesterprojectspring.model.dto.RecipeDto;
import ru.kpfu.itis.semesterprojectspring.model.entity.Recipe;
import ru.kpfu.itis.semesterprojectspring.model.response.my.DataResponse;
import ru.kpfu.itis.semesterprojectspring.model.response.my.DefaultResponse;
import ru.kpfu.itis.semesterprojectspring.service.RecipeService;
import ru.kpfu.itis.semesterprojectspring.utils.converter.RecipeConverter;

@RestController
@Component
@RequestMapping(value = "/api/recipes")
@AllArgsConstructor
@Tags(
        value = {
                @Tag(name = "Recipe Controller")
        }
)
public class RecipeRestController {

    private static final String ADD_SUCCESS = "Added recipe successfully";
    private static final String UPDATE_SUCCESS = "Recipe updated successfully";
    private static final String DELETE_SUCCESS = "Recipe deleted successfully";
    private static final String JSON_TYPE = "application/json";

    private RecipeService recipeService;

    @Operation(summary = "Add new recipe")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = ADD_SUCCESS),
            @ApiResponse(responseCode = "404", description = "Error adding recipe")
    })
    @GetMapping("/add")
    public ResponseEntity<?> addRecipe(
            @Parameter(description = "Recipe object", content = {@Content(mediaType = JSON_TYPE, schema = @Schema(implementation = DefaultResponse.class))})
            @RequestBody RecipeDto recipeDto
    ) {
        try {
            recipeService.saveRecipe(
                    Recipe.builder()
                            .name(recipeDto.getName())
                            .calories(recipeDto.getCalories())
                            .proteins(recipeDto.getProteins())
                            .fat(recipeDto.getFat())
                            .carbs(recipeDto.getCarbs())
                            .build()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(new DefaultResponse(ADD_SUCCESS));
        } catch (IllegalRecipeException ex) {
            return new ResponseEntity<>(new DefaultResponse(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Get all recipes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All recipes")
    })
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(new DataResponse<>(recipeService.getAll()));
    }

    @Operation(summary = "Get recipe by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recipe found", content = {@Content(mediaType = JSON_TYPE, schema = @Schema(implementation = DataResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Recipe not found")
    })
    @GetMapping("/info/{id}")
    public ResponseEntity<?> getById(
            @Parameter(description = "Recipe id", required = true)
            @PathVariable Long id
    ) {
        try {
            Recipe recipe = recipeService.getById(id);
            return ResponseEntity.ok(new DataResponse<>(recipe));
        } catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(new DefaultResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Update recipe by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recipe updated", content = {@Content(mediaType = JSON_TYPE, schema = @Schema(implementation = DefaultResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Recipe not found")
    })
    @GetMapping("/{id}/name")
    public ResponseEntity<?> updateRecipeName(
            @Parameter(description = "Recipe id", required = true)
            @PathVariable Long id,
            @Parameter(description = "New Recipe name", required = true)
            @RequestParam String newName
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

    @Operation(summary = "Delete recipe by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recipe deleted", content = {@Content(mediaType = JSON_TYPE, schema = @Schema(implementation = DefaultResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Recipe not found")
    })
    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteRecipe(
            @Parameter(description = "Recipe id", required = true)
            @PathVariable Long id
    ) {
        try {
            recipeService.deleteRecipe(id);
            return ResponseEntity.ok(new DefaultResponse(DELETE_SUCCESS));
        } catch (IllegalRecipeException ex) {
            return new ResponseEntity<>(new DefaultResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
