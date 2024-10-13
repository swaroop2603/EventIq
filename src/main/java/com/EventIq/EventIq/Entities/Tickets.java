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
public class Tickets {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID ticketId;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Events event;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserTable user;

    private Integer totalTickets;

    @ManyToOne
    @JoinColumn(name = "ticket_price_id")
    private TicketPrices ticketPrices;

    @OneToMany(mappedBy = "ticket")
    private Set<TicketUsers> ticketUsers;

    @OneToOne(mappedBy = "ticket")
    private Transactions transaction;

    @CreationTimestamp
    private LocalDateTime purchasedAt;

}
