package com.fmi.repository;

import com.fmi.model.Ticket;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
public class TicketRepository implements TicketRepositoryInterface {
    private Map<Long, Ticket> idTicket;

    @Override
    public void createTicket(@NonNull Ticket t) {
        Long id = t.getTicketId();

        if (idTicket.containsKey(id)) {
            return;
        }

        idTicket.put(id, t);
    }

    @Override
    public void removeTicket(Long id) {
        idTicket.remove(id);
    }

    @Override
    public Ticket findById(Long id) {
        return idTicket.get(id);
    }

    @Override
    public void updateTicketById(@NonNull Ticket ticket) {
        Long id = ticket.getTicketId();

        if(!idTicket.containsKey(id)){
            return;
        }

        removeTicket(id);
        idTicket.put(id, ticket);
    }

    public List<Ticket> getAllTickets(){
        return new ArrayList<>(idTicket.values());
    }
}
