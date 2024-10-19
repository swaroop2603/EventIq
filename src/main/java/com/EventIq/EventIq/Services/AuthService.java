package com.EventIq.EventIq.Services;

import com.EventIq.EventIq.Dtos.LoginAndSignUpDtos.SignupDto;
import com.EventIq.EventIq.Dtos.globalDtos.UserDto;

public interface AuthService {
    String[] login(String email,String password);
    UserDto signUp(SignupDto signupDto);
}
