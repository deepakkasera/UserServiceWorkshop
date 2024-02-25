package com.example.userserviceworkshop.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private Long userId;
    private ResponseStatus responseStatus;
}
