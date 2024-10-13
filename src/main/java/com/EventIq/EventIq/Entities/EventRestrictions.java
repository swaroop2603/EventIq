package com.EventIq.EventIq.Entities;

import com.EventIq.EventIq.Entities.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventRestrictions {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID eventRestrictionId;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<Gender> allowedGenders;

    private Integer allowedMinimumAge;

    private Integer allowedMaximumAge;

    @OneToOne
    @JoinColumn(name = "event_id")
    private Events event;


}
