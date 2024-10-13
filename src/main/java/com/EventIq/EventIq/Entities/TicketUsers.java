package com.EventIq.EventIq.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID tickedUserId;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Tickets ticket;

    private String ticketHolderName;

    private String ticketHolderAge;

}
