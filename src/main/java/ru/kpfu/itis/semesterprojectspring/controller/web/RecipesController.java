package ru.kpfu.itis.semesterprojectspring.controller.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.semesterprojectspring.model.dto.RecordDto;
import ru.kpfu.itis.semesterprojectspring.model.entity.Recipe;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;
import ru.kpfu.itis.semesterprojectspring.service.RecipeService;
import ru.kpfu.itis.semesterprojectspring.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/recipes")
public class RecipesController {

    private final RecipeService recipeService;
    private final UserService userService;

    @GetMapping("/list")
    public String view(
            ModelMap map,
            Principal principal
    ) {
        if (principal != null) {
            map.addAttribute("user", userService.findUserByEmail(principal.getName()));
        }
        List<Recipe> recipes = recipeService.getAll();
        map.addAttribute("recipes", recipes);
        return "recipes";
    }

    @GetMapping("/favorite")
    public String showFavorite(
            ModelMap map,
            Principal principal
    ) {
        User user = userService.findUserByEmail(principal.getName());
        map.addAttribute("user", user);
        map.addAttribute("recipes", user.getPreferredRecipes());
        return "recipes";
    }

    @GetMapping("/consume")
    public String consume(
            @RequestParam("recipeId") Long id,
            @RequestParam Long grams,
            Principal principal
    ) {
        Recipe recipe = recipeService.getById(id);

        userService.updateUserRecord(
                userService.findUserByEmail(principal.getName()),
                new RecordDto(
                        recipe.getCalories() * grams / 100,
                        recipe.getCarbs() * grams / 100,
                        recipe.getFat() * grams / 100,
                        recipe.getProteins() * grams / 100
                )
        );
        return "redirect:/recipes/list";
    }

    @GetMapping("/add-to-prefer")
    public String addToPrefer(
            @RequestParam Long recipeId,
            Principal principal
    ) {
        User user = userService.findUserByEmail(principal.getName());
        Recipe recipe = recipeService.getById(recipeId);
        userService.addFavoriteRecipe(user, recipe);
        return "redirect:/recipes/list";
    }
}
