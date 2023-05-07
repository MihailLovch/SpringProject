package ru.kpfu.itis.semesterprojectspring.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.semesterprojectspring.exception.IllegalUserException;
import ru.kpfu.itis.semesterprojectspring.model.entity.Recipe;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;
import ru.kpfu.itis.semesterprojectspring.repository.UserRepository;
import ru.kpfu.itis.semesterprojectspring.service.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signInUser(User user) throws IllegalUserException {
        if (userRepository.findUserByEmail(user.getEmail()) == null) {
            userRepository.save(user);
        } else {
            throw new IllegalUserException("User with this email already exists");
        }
    }

    @Override
    public User loginUser(User user) {
        User findedUser = userRepository.findUserByEmail(user.getEmail());
        if (findedUser == null || passwordEncoder.matches(findedUser.getPassword(), user.getPassword())) {
            throw new IllegalUserException("Incorrect Email or Password");
        } else {
            return findedUser;
        }
    }

    @Override
    public User findUserByEmail(String name) {
        return userRepository.findUserByEmail(name);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void updateUser(User user) {
        if (userRepository.findUserByEmail(user.getEmail()) != null) {
            userRepository.save(user);
        } else {
            throw new IllegalUserException("User with this email not found");
        }
    }

    @Override
    public void addFavoriteRecipe(User user, Recipe recipe) {
        List<Recipe> recipes =  user.getPreferredRecipes();
        if (!recipes.contains(recipe)){
            recipes.add(recipe);
        }
        user.setPreferredRecipes(recipes);
        userRepository.save(user);
    }
}
