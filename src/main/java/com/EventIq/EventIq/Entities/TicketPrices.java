package com.EventIq.EventIq.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketPrices {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ticketPriceId;

    private Double adultPrice; // Price for adults
    private Double childPrice; // Price for children under 12


    private Integer maximumAvailableTickets;

    private Integer TicketsSold;

    private String ticketPriceDetails;

    @ManyToOne
    @JoinColumn(name = "event_id",nullable = false)
    private Events event;
}
