package com.example.userserviceworkshop.services;

import com.example.userserviceworkshop.dtos.SignUpRequestDto;
import com.example.userserviceworkshop.exceptions.LogInFaliedException;
import com.example.userserviceworkshop.models.User;
import com.example.userserviceworkshop.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String email, String password) throws LogInFaliedException {
        //Steps :
        //1. Go to DB and check if there's a user with the given emailId.
        //2. If yes, check the password with the given password.
        //3. If not, call the signUp method.

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            //User is not registered yet, call the signup method.
            return signUp(email, password);
        }
        User user = optionalUser.get();
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (user.getPassword().equals(password)) {
            //SUCCESSFUL LOGIN
            return user;
        } else {
            //throw an Exception.
            throw new LogInFaliedException("Wrong Password");
        }
    }

    public User signUp(String email, String password) {
        User user = new User();
        user.setEmail(email);

        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(password);

        return userRepository.save(user);
    }

    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        System.out.println("getUserById() method called");

        return optionalUser.get();
    }
}
