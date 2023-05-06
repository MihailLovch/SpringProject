package ru.kpfu.itis.semesterprojectspring.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.semesterprojectspring.exception.IllegalUserException;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;
import ru.kpfu.itis.semesterprojectspring.repository.UserRepository;
import ru.kpfu.itis.semesterprojectspring.service.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signInUser(User user) throws IllegalUserException{
        if (userRepository.findUserByEmail(user.getEmail()) == null){
            userRepository.save(user);
        }else{
            throw new IllegalUserException("User with this email already exists");
        }
    }

    @Override
    public User loginUser(User user){
        User findedUser = userRepository.findUserByEmail(user.getEmail());
        if (findedUser == null || passwordEncoder.matches(findedUser.getPassword(), user.getPassword())){
            throw new IllegalUserException("Incorrect Email or Password");
        }else {
            return findedUser;
        }
    }
}
