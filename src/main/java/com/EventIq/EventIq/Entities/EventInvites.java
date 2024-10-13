package com.EventIq.EventIq.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventInvites {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID eventInviteId;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserTable user;

    @ManyToOne
    @JoinColumn(name = "event_id",nullable = false)
    private Events event;

    @CreationTimestamp
    private LocalDateTime invited_at;



}
