package ru.kpfu.itis.semesterprojectspring.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.semesterprojectspring.model.dto.RandomRecipeDto;
import ru.kpfu.itis.semesterprojectspring.remote.RecipeApiService;
import ru.kpfu.itis.semesterprojectspring.utils.mapper.RemoteMapper;

@Controller
public class RandomRecipeController {

    @Autowired
    private RecipeApiService recipeApiService;

    @GetMapping("/random-recipe")
    public String getRandomRecipe(ModelMap map){
        try {
            RandomRecipeDto dto = RemoteMapper.mapToRandomRecipeDto(recipeApiService.requestRandomRecipe());
            map.addAttribute("imageUrl",dto.getImageUrl());
            map.addAttribute("calorie",dto.getCalories());
            map.addAttribute("fat",dto.getFats());
            map.addAttribute("carb",dto.getCarbs());
            map.addAttribute("info",dto.getInformation());
            map.addAttribute("recipe",dto.getInstruction());
            return "randomRecipe";
        }catch (Exception exception){
            //TODO(): change to error page
            System.out.println(exception.getLocalizedMessage());
            return "redirect:/home";
        }
    }
}
