package com.fmi.service;

import com.fmi.model.Event;
import com.fmi.model.Ticket;
import com.fmi.model.User;
import com.fmi.repository.EventRepository;
import com.fmi.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TicketService implements TicketServiceInterface {
    private EventRepository eventRepo;
    private TicketRepository ticketRepo;

    @Autowired
    public TicketService(EventRepository eventRepo, TicketRepository ticketRepo) {
        this.eventRepo = eventRepo;
        this.ticketRepo = ticketRepo;
    }

    @Override
    public void createTicket(Ticket u) {
        ticketRepo.createTicket(u);
    }

    @Override
    public void removeTicket(Long id) {
        ticketRepo.removeTicket(id);
    }

    @Override
    public Ticket findById(Long id) {
        return ticketRepo.findById(id);
    }

    @Override
    public void updateTicketById(Ticket id) {
        ticketRepo.updateTicketById(id);
    }

    @Override
    public List<Ticket> findAllTicketsByUser(User u) {
        return ticketRepo.getAllTickets().stream()
                .filter(t -> t.getUser().getId().equals(u.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> findAllTicketByEvent(Event e) {
        return ticketRepo.getAllTickets().stream()
                .filter(t -> t.getTicketId().equals(e.getEventId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> findAllEventsBetweenDates(LocalDate from, LocalDate to) {
        return eventRepo.getAllEvents().stream()
                .filter(e -> e.getDate().toLocalDate().isAfter(from))
                .filter(e -> e.getDate().toLocalDate().isBefore(to))
                .collect(Collectors.toList());
    }
}
