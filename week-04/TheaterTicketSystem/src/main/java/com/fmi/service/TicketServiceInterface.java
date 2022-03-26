package com.fmi.service;

import com.fmi.model.Event;
import com.fmi.model.Ticket;
import com.fmi.model.User;

import java.time.LocalDate;
import java.util.List;

public interface TicketServiceInterface {

    /**
     * Create and validate ticket.
     * Can NOT create ticket in the past.
     * Can NOT create ticket with negative price.
     * Can NOT duplicate row and seat same event.
     * @param u
     */
    void createTicket(Ticket u);

    void removeTicket(Long id);

    Ticket findById(Long id);

    void updateTicketById(Ticket id);

    /**
     * Return all tickets bought by a user
     * @param id
     * @return
     */
    List<Ticket> findAllTicketsByUser(User id);

    /**
     * Return all sold tickets by event
     * @param event
     * @return
     */
    List<Ticket> findAllTicketByEvent(Event event);

    /**
     * Return all available events for between two dates
     * @param from
     * @param to
     * @return
     */
    List<Event> findAllEventsBetweenDates(LocalDate from, LocalDate to);
}
