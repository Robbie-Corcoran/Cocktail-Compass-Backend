package com.example.cocktailcompass.user.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSignUpDTO {
    private String name;
    private String username;
    private String email;
    private String password;
}
