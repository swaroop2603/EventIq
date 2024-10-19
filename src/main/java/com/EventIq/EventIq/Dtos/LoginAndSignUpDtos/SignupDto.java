package com.EventIq.EventIq.Dtos.LoginAndSignUpDtos;

import com.EventIq.EventIq.Entities.enums.Gender;
import com.EventIq.EventIq.annotations.AgeValidator;
import com.EventIq.EventIq.annotations.PasswordValidator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignupDto {

    @NotBlank
    private String firstName;

    private String lastName;

    @NotBlank
    @Email(message="valid email is required")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @PasswordValidator
    private String password;

    @Size(min=10,max = 12,message = "phone length must be between 8 to 12 chars")
    private String phoneNumber;

    private String country;

    @NotNull(message = "gender must be provided")
    private Gender gender;

    @NotNull(message = "date of birth must be provided")
    @AgeValidator
    private LocalDate dateOfBirth;

    private String profilePicture;

}
