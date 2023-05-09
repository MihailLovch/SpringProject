package ru.kpfu.itis.semesterprojectspring.service.implementation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.semesterprojectspring.exception.IllegalUserException;
import ru.kpfu.itis.semesterprojectspring.model.dto.RecordDto;
import ru.kpfu.itis.semesterprojectspring.model.entity.Recipe;
import ru.kpfu.itis.semesterprojectspring.model.entity.Record;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;
import ru.kpfu.itis.semesterprojectspring.repository.RecordRepository;
import ru.kpfu.itis.semesterprojectspring.repository.UserRepository;
import ru.kpfu.itis.semesterprojectspring.service.UserService;
import ru.kpfu.itis.semesterprojectspring.utils.date.DateExtension;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RecordRepository recordRepository;
    private final PasswordEncoder passwordEncoder;

    @PersistenceContext
    private final EntityManager em;

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
        List<Recipe> recipes = user.getPreferredRecipes();
        if (!recipes.contains(recipe)) {
            recipes.add(recipe);
        }
        user.setPreferredRecipes(recipes);
        userRepository.save(user);
    }

    @Override
    public void updateUserRecord(User user, RecordDto recordDto) {
        Record record = null;
        for (Record record1 : user.getRecords()) {
            if (DateExtension.checkDatesTheSameDay(Calendar.getInstance().getTime(),record1.getDate())) {
                record = record1;
                break;
            }
        }
        if (record == null) {
            record = Record.builder()
                    .calorie(recordDto.getCalorie())
                    .carb(recordDto.getCarb())
                    .fat(recordDto.getFat())
                    .proteins(recordDto.getProtein())
                    .date(Calendar.getInstance().getTime())
                    .user(user)
                    .build();
            user.getRecords().add(record);
        } else {
            record.setCalorie(record.getCalorie() + recordDto.getCalorie());
            record.setFat(record.getFat() + recordDto.getFat());
            record.setProteins(record.getProteins() + recordDto.getProtein());
            record.setCarb(record.getCarb() + recordDto.getCarb());
        }
        recordRepository.save(record);
    }

    @Override
    public List<String> findTopRecipesByCalories(User user) {
        return userRepository.findTopRecipesByCalories(user.getEmail());
    }

}
