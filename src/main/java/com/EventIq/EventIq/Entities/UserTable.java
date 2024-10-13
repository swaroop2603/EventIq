package com.EventIq.EventIq.Entities;

import com.EventIq.EventIq.Entities.enums.Gender;
import com.EventIq.EventIq.Entities.enums.UserRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;


    private String firstName;

    private String lastName;

    @Column(unique = true,nullable = false)
    private String email;

    private String password;

    private String phoneNumber;

    private String country;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate dateOfBirth;

    @Column(columnDefinition ="boolean default false" )
    private Boolean isVerified=false;

    private String profilePicture;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<UserRoles> role;


    @OneToMany(mappedBy = "user")
    private Set<Organisation> organisations;

    @OneToMany(mappedBy = "user")
    private Set<Events> events;

    @OneToMany(mappedBy = "user")
    private Set<EventInvites> eventInvites;

    @OneToMany(mappedBy = "user")
    private Set<BlockedOrganizerUsers> blockedOrganizerUsers;

    @OneToMany(mappedBy = "user")
    private Set<Tickets> tickets;

    @CreationTimestamp
    private LocalDateTime created_at;

}
