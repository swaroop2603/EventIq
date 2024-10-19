package com.EventIq.EventIq.Dtos.LoginAndSignUpDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginDto {

    private String email;

    private String password;

}
