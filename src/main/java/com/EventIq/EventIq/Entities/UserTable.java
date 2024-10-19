package com.EventIq.EventIq.Entities;

import com.EventIq.EventIq.Entities.enums.Gender;
import com.EventIq.EventIq.Entities.enums.UserRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserTable implements UserDetails {

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


    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }
}
