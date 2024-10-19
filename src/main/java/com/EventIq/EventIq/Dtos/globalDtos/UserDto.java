package com.EventIq.EventIq.Dtos.globalDtos;

import com.EventIq.EventIq.Entities.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private UUID userId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String country;

    private Gender gender;

    private LocalDate dateOfBirth;

    private Boolean isVerified=false;

    private String profilePicture;

//    private Set<UserRoles> role;
//
//
//    private Set<Organisation> organisations;
//
//    private Set<Events> events;
//
//    private Set<EventInvites> eventInvites;
//
//    private Set<BlockedOrganizerUsers> blockedOrganizerUsers;
//
//    private Set<Tickets> tickets;

    private LocalDateTime created_at;
}
