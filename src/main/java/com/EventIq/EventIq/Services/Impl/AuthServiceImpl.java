package com.EventIq.EventIq.Services.Impl;

import com.EventIq.EventIq.Dtos.LoginAndSignUpDtos.SignupDto;
import com.EventIq.EventIq.Dtos.globalDtos.UserDto;
import com.EventIq.EventIq.Entities.UserTable;
import com.EventIq.EventIq.Entities.enums.UserRoles;
import com.EventIq.EventIq.Repositories.UserRepo;
import com.EventIq.EventIq.Security.JWTService;
import com.EventIq.EventIq.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    public String[] login(String email, String password) {
        System.out.println(email);

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
            UserTable user = (UserTable) authentication.getPrincipal();
            String accessToken=jwtService.generateAccessToken(user);
            String refreshToken=jwtService.generateRefreshToken(user);
            return new String[]{accessToken,refreshToken};

    }
    @Override
    public UserDto signUp(SignupDto signupDto) {
        UserTable userExists=userRepo.findByEmail(signupDto.getEmail()).orElse(null);
        if(userExists!=null)
            throw new RuntimeException("user is already present with this email");
    UserTable userEntity=modelMapper.map(signupDto,UserTable.class);
    userEntity.setPassword(passwordEncoder.encode(signupDto.getPassword()));
    userEntity.setRole(Set.of(UserRoles.ATTENDEE));
    userEntity.setIsVerified(false);
    UserTable createdUser=userRepo.save(userEntity);
        return modelMapper.map(createdUser,UserDto.class);
    }



}
