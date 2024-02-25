package com.example.userserviceworkshop;

import com.example.userserviceworkshop.controllers.UserController;
import com.example.userserviceworkshop.dtos.SignUpRequestDto;
import com.example.userserviceworkshop.dtos.SignUpResponseDto;
import com.example.userserviceworkshop.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceWorkshopApplication implements CommandLineRunner  {
//    private UserController userController;
//
//    UserServiceWorkshopApplication(UserController userController) {
//        this.userController = userController;
//    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceWorkshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        SignUpRequestDto requestDto = new SignUpRequestDto();
//        requestDto.setEmail("deepak@scaler.com");
//        requestDto.setPassword("abc123");
//
//        SignUpResponseDto responseDto = userController.signUp(requestDto);
//        System.out.println(responseDto.getResponseStatus());
    }
}
