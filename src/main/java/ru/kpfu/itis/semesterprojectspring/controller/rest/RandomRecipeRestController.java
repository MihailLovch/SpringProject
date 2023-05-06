package ru.kpfu.itis.semesterprojectspring.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.semesterprojectspring.model.dto.RandomRecipeDto;
import ru.kpfu.itis.semesterprojectspring.remote.RecipeApiService;
import ru.kpfu.itis.semesterprojectspring.utils.mapper.RemoteMapper;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RandomRecipeRestController {

    private RecipeApiService recipeApiService;

    @GetMapping("/random-recipe")
    public ResponseEntity<?> getRandomRecipe(){
        try{
            RandomRecipeDto randomRecipeDto = RemoteMapper.mapToRandomRecipeDto(recipeApiService.requestRandomRecipe());
            return ResponseEntity.ok(randomRecipeDto);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
