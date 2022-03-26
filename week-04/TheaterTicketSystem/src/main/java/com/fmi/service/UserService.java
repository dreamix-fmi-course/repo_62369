package com.fmi.service;

import com.fmi.model.Event;
import com.fmi.model.Ticket;
import com.fmi.model.User;
import com.fmi.repository.TicketRepository;
import com.fmi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class UserService implements UserServiceInterface {
    private UserRepository userRepo;
    private TicketRepository ticketRepo;

    @Autowired
    public UserService(UserRepository userRepo, TicketRepository ticketRepo) {
        this.userRepo = userRepo;
        this.ticketRepo = ticketRepo;
    }

    @Override
    public void createUser(User u) {
        userRepo.addUser(u);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteUser(id);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public void updateUserInformation(User user) {
        userRepo.updateUser(user);
    }

    @Override
    public List<Event> getAllVisitedEvents() {
        return ticketRepo.getAllTickets().stream()
                .map(Ticket::getEvent)
                .distinct()
                .filter(e -> e.getDate().compareTo(LocalDateTime.now()) < 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> getAllVisitedEventsInPastMonth() {
        return ticketRepo.getAllTickets().stream()
                .map(Ticket::getEvent)
                .distinct()
                .filter(e -> e.getDate().equals(LocalDateTime.now().minusMonths(1)))
                .collect(Collectors.toList());
    }
}
