package com.example.userserviceworkshop.controllers;

import com.example.userserviceworkshop.dtos.*;
import com.example.userserviceworkshop.dtos.ResponseStatus;
import com.example.userserviceworkshop.models.User;
import com.example.userserviceworkshop.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    //Dependency Injection via Constructor
    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto responseDto = new LoginResponseDto();
        try {
            User user = userService.login(loginRequestDto.getEmail(),
                    loginRequestDto.getPassword());

            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setUserId(user.getId());
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }

    @PostMapping("/signup")
    public SignUpResponseDto signUp(@RequestBody SignUpRequestDto requestDto) {
        SignUpResponseDto responseDto = new SignUpResponseDto();
        try {
            User user = userService.signUp(requestDto.getEmail(),
                    requestDto.getPassword());

            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setEmail(user.getEmail());
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);

        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
