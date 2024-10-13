package com.EventIq.EventIq.Controllers;

import com.EventIq.EventIq.Dtos.LoginDto;
import com.EventIq.EventIq.Dtos.LoginResponseDto;
import com.EventIq.EventIq.Dtos.SignupDto;
import com.EventIq.EventIq.Dtos.UserDto;
import com.EventIq.EventIq.Services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginDto loginDto){
       String response=authService.login(loginDto.getEmail(),loginDto.getPassword());
       System.out.println(response);
        return ResponseEntity.ok(new LoginResponseDto(response));
    }

}
