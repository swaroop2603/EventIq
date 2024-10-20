package com.EventIq.EventIq.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlockedEventUsers {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID eventBlockedUserId;

    @ManyToOne
    @JoinColumn(name = "event_id",nullable = false)
    private Events event;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private  UserTable user;

    private String reasonOgBlocking;

    @CreationTimestamp
    private LocalDateTime blockedAt;


}
