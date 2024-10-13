package com.EventIq.EventIq.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockedOrganizerUsers {


    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID organiserBlockedUserId;

    @ManyToOne
    @JoinColumn(name = "organisation_id",nullable = false)
    private Organisation organisation;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private  UserTable user;

    private String reasonOgBlocking;

    @CreationTimestamp
    private LocalDateTime blockedAt;
}
