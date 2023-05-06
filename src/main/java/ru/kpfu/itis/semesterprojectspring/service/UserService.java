package ru.kpfu.itis.semesterprojectspring.service;

import ru.kpfu.itis.semesterprojectspring.model.entity.User;

public interface UserService {
    void signInUser(User user);

    User loginUser(User user);
}
