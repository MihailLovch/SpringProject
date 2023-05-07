package ru.kpfu.itis.semesterprojectspring.service;

import ru.kpfu.itis.semesterprojectspring.model.dto.RecordDto;
import ru.kpfu.itis.semesterprojectspring.model.entity.Recipe;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;

public interface UserService {
    void signInUser(User user);
    User loginUser(User user);
    User findUserByEmail(String name);

    void deleteUser(User user);

    void updateUser(User user);

    void addFavoriteRecipe(User user, Recipe recipe);

    void updateUserRecord(User user, RecordDto recordDto);
}
