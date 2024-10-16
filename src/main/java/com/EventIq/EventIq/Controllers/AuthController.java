package com.EventIq.EventIq.Controllers;

import com.EventIq.EventIq.Dtos.LoginDto;
import com.EventIq.EventIq.Dtos.LoginResponseDto;
import com.EventIq.EventIq.Dtos.SignupDto;
import com.EventIq.EventIq.Dtos.UserDto;
import com.EventIq.EventIq.Services.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    final AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@Valid @RequestBody SignupDto signupDto){
        return ResponseEntity.ok(authService.signUp(signupDto));
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginDto loginDto, HttpServletResponse httpServletResponse){
       String[] tokens=authService.login(loginDto.getEmail(),loginDto.getPassword());

        Cookie cookie=new Cookie("token",tokens[1]);
        cookie.setHttpOnly(true);
        httpServletResponse.addCookie(cookie);
        return ResponseEntity.ok(new LoginResponseDto(tokens[0]));
    }

}
