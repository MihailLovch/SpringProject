package ru.kpfu.itis.semesterprojectspring.utils.converter;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.semesterprojectspring.model.dto.RecipeDto;
import ru.kpfu.itis.semesterprojectspring.model.entity.Recipe;
import ru.kpfu.itis.semesterprojectspring.service.RecipeService;

import java.util.Collections;
import java.util.Set;


@Component
@AllArgsConstructor
public class RecipeConverter implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(RecipeDto.class, Recipe.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        try{
            if (RecipeDto.class.equals(sourceType.getType())){
                RecipeDto recipeDto = (RecipeDto) source;
                return Recipe.builder()
                        .name(recipeDto.getName())
                        .calories(recipeDto.getCalories())
                        .proteins(recipeDto.getProteins())
                        .fat(recipeDto.getFat())
                        .carbs(recipeDto.getCarbs())
                        .build();
            }else{
                throw new IllegalArgumentException("Can't convert " + source + " into suitable type");
            }
        }catch (Exception ex){
            throw new IllegalArgumentException("Can't convert " + source + " into suitable type");
        }
    }
}
