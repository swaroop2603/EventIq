package com.EventIq.EventIq.Dtos.LoginAndSignUpDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private String accessToken;
//    private String refreshToken;
}
