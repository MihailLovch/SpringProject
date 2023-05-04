package ru.kpfu.itis.semesterprojectspring.remote;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.semesterprojectspring.remote.apiresponse.RecipeResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

@Service
@AllArgsConstructor
public class RecipeApiService {

    private static final String API_KEY = "a670dfbab0004282867a036141fad0ad";
    private static final Integer AMOUNT_OF_RECIPES_IN_API = 100_000;
    private static final String API_KEY_HEADER = "x-api-key";
    private static final String BASE_URL = "https://api.spoonacular.com/recipes/{id}/information?includeNutrition=true";
    private final Gson g;
    private final HttpClient httpClient;

    public RecipeResponse requestRandomRecipe() throws Exception {
        int id = new Random().nextInt(AMOUNT_OF_RECIPES_IN_API);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(BASE_URL.replace("{id}", String.valueOf(id))))
                .GET()
                .header(API_KEY_HEADER, API_KEY)
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200){
            return requestRandomRecipe();
        }
        return g.fromJson(response.body(), RecipeResponse.class);

    }

}
