package com.airline.management.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TicketType {
    CPN_4(1),
    CPN_2(2),
    MEO(3),
    VOH(4),
    STOCK(5),
    AUTO(6),
    ELECTRONIC(7),
    REFUND_VOID(8);

    private final int value;

    TicketType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static TicketType fromValue(int value) {
        for (TicketType type : TicketType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid TicketType value: " + value);
    }
}
