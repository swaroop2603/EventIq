package com.EventIq.EventIq.Services;

import com.EventIq.EventIq.Dtos.SignupDto;
import com.EventIq.EventIq.Dtos.UserDto;

public interface AuthService {
    String[] login(String email,String password);
    UserDto signUp(SignupDto signupDto);
}
