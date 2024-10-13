package com.EventIq.EventIq.Entities;

import com.EventIq.EventIq.Entities.enums.TransactionAction;
import com.EventIq.EventIq.Entities.enums.TransactionStatus;
import com.EventIq.EventIq.Entities.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transactions {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID transaction_id;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Tickets ticket;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserTable user;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private TransactionAction transactionAction;

    private Double transactionAmount;

    @CreationTimestamp
    private LocalDateTime transactionAT;



}
