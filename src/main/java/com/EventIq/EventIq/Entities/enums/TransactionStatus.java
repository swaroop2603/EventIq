package com.EventIq.EventIq.Entities.enums;

public enum TransactionStatus {
    PENDING,       // Transaction has been initiated but not yet completed.

    COMPLETED,     // Transaction has been successfully completed.

    FAILED,        // Transaction failed due to some issue (e.g., payment failure).

    CANCELED,      // Transaction was canceled by the user or system.

    REFUNDED       // Transaction was successfully refunded after being completed.
}
