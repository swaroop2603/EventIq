package com.EventIq.EventIq.Entities.enums;

public enum EventType {
    FREE, // No ticket required, open to everyone
    PAID, // Requires payment for registration, but everyone can register
    INVITE_ONLY, // Only accessible by invitation, can be either paid or unpaid
    FREE_WITH_REGISTRATION, // Free but requires user registration
    PAID_WITH_INVITE // Paid events that are accessible only by invitation

}
