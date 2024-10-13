package com.EventIq.EventIq.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Organisation {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID organisationId;

    private String organisationName;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserTable user;

    private LocalDateTime organisationStartedDate;

    private String organisationHeadOffice;

    private String organisationDetails;

    private String organisationAddress;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "organisation")
    private Set<BlockedOrganizerUsers> blockedOrganizerUsers;

    @OneToMany(mappedBy = "organisation")
    private Set<Events> events;


}
