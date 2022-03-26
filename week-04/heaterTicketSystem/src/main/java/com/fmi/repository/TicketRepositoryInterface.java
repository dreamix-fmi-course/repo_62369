package com.fmi.repository;

import com.fmi.model.Ticket;

public interface TicketRepositoryInterface {

    /**
     * Create ticket
     */
    void createTicket(Ticket u);

    /**
     * Remove ticket
     */
    void removeTicket(Long id);

    /**
     * Find ticket by Id
     */
    Ticket findById(Long id);

    /**
     * Update ticket information
     */
    void updateTicketById(Ticket ticket);
}
