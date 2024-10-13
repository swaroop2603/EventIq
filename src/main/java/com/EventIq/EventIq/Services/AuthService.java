package com.EventIq.EventIq.Services;

import com.EventIq.EventIq.Dtos.LoginDto;
import com.EventIq.EventIq.Dtos.SignupDto;
import com.EventIq.EventIq.Dtos.UserDto;

public interface AuthService {
    UserDto signUp(SignupDto signupDto);
    void login(LoginDto loginDto);
}
