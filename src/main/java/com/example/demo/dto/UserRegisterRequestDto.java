package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequestDto {
    @Column(nullable = false, length = 8)
    private String userName;

    @Column(nullable = false, length = 8)
    private String passWord;
}
