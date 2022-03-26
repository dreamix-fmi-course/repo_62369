package com.fmi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Objects;

@Data
public class Ticket {

    @NonNull
    private Long ticketId;
    private BigDecimal price;
    private int row;
    private int seat;
    private User user;
    private Event event;

    @Autowired
    public Ticket(@NonNull Long ticketId, BigDecimal price, int row, int seat, User user, Event event) {
        this.ticketId = ticketId;
        this.price = price;

        this.row = row;
        this.seat = seat;

        this.user = user;
        this.event = event;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, event);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Ticket)) {
            return false;
        }

        Ticket t = (Ticket) o;
        return Objects.equals(ticketId, t.getTicketId()) && Objects.equals(event, t.getEvent());
    }
}
