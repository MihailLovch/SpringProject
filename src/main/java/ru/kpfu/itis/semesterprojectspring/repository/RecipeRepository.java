package ru.kpfu.itis.semesterprojectspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.semesterprojectspring.model.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {

}
