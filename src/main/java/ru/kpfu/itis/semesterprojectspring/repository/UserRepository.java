package ru.kpfu.itis.semesterprojectspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    @Query("SELECT r.name FROM User u JOIN u.preferredRecipes r WHERE u.email = :email AND r.calories IN (SELECT r2.calories FROM Recipe r2 ORDER BY r2.calories DESC LIMIT 5)")
    List<String> findTopRecipesByCalories(@Param("email") String email);
}
