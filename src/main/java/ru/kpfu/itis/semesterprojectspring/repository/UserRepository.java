package ru.kpfu.itis.semesterprojectspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
