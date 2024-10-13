package com.EventIq.EventIq.Entities;

import com.EventIq.EventIq.Entities.enums.EventStatus;
import com.EventIq.EventIq.Entities.enums.EventType;
import com.EventIq.EventIq.Entities.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Events {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID eventId;

    private String eventName;

    @ManyToOne
    @JoinColumn(name = "organisation_id",nullable = false)
    private Organisation organisation;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserTable user;

    private String eventDetails;

    private String eventLocation;

    private LocalDateTime eventStartTime;

    private LocalDateTime eventEndTime;

    private LocalDateTime ticketsAvailableTime;

    private LocalDateTime ticketsCloseTime;

    private Genre genre;

    private EventType eventType;

    private EventStatus eventStatus;

    private String goodies;

    private Double eventBudget;

    private Integer maxTicketsPerUser;

    @OneToMany(mappedBy = "event")
    private Set<TicketPrices> ticketPrices;

    @OneToOne(mappedBy = "event")
    private EventRestrictions eventRestrictions;

    @OneToMany(mappedBy = "event")
    private Set<EventInvites> eventInvites;

    @OneToMany(mappedBy = "event")
    private Set<BlockedEventUsers> blockedEventUsers;

    @OneToMany(mappedBy = "event")
    private Set<Tickets> tickets;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;








}
