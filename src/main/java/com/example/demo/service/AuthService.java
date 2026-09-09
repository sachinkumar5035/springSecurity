package com.example.demo.service;


import com.example.demo.dto.UserRegisterRequestDto;
import com.example.demo.dto.UserRegisterResponseDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
    }


    public UserRegisterResponseDto registerUser(UserRegisterRequestDto userRegisterRequestDto) {
        User user = new User();
        user.setUserName(userRegisterRequestDto.getUserName());
        user.setPassWord(passwordEncoder.encode(userRegisterRequestDto.getPassWord()));
        user.setEnabled(true);
        userRepository.save(user);
        UserRegisterResponseDto responseDto = new UserRegisterResponseDto();
        responseDto.setUserName(user.getUserName());
        responseDto.setMessage("user registered successfully");
        return responseDto;
    }

}
