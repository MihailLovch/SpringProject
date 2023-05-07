package ru.kpfu.itis.semesterprojectspring.service;

import ru.kpfu.itis.semesterprojectspring.model.entity.User;

public interface UserService {
    void signInUser(User user);
    User loginUser(User user);
    User findUserByEmail(String name);

    void deleteUser(User user);

    void updateUser(User user);
}
