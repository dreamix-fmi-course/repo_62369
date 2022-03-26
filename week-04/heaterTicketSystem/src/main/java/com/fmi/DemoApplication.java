package com.fmi;

import com.fmi.model.Event;
import com.fmi.model.Ticket;
import com.fmi.model.User;
import com.fmi.service.EventService;
import com.fmi.service.TicketService;
import com.fmi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    EventService eventService;

    @Autowired
    TicketService ticketService;

    @Autowired
    UserService userService;

    @Override
    public void run(String... args) {
        // System.out.println("Hello Spring");
        User u1 = new User(111L, "Maria", "maria@gmail.com");
        User u2 = new User(112L, "Pesho", "pesho@gmail.com");
        User u3 = new User(113L, "Desi", "desi@gmail.com");

        Event e1 = new Event(
                211L,
                "Romeo and Juliet",
                LocalDateTime.of(2022, 3, 20, 18, 0),
                "Sofia Theater"
        );

        Event e2 = new Event(
                212L,
                "Undress for The Evening",
                LocalDateTime.of(2022, 4, 25, 19, 0),
                "Plovdiv Theater"
        );

        Event e3 = new Event(
                213L,
                "In other words",
                LocalDateTime.of(2022, 5, 30, 20, 0),
                "Varna Theater"
        );

        Ticket t1 = new Ticket(311L, new BigDecimal("25"), 1, 4, u1, e1);
        Ticket t2 = new Ticket(312L, new BigDecimal("15"), 2, 5, u2, e2);
        Ticket t3 = new Ticket(313L, new BigDecimal("20"), 3, 6, u2, e2);

        userService.createUser(u1);
        userService.createUser(u2);
        userService.createUser(u3);

        eventService.createEvent(e1);
        eventService.createEvent(e2);
        eventService.createEvent(e3);

        ticketService.createTicket(t1);
        ticketService.createTicket(t2);
        ticketService.createTicket(t3);

        System.out.println("All visited events:");
        System.out.println(userService.getAllVisitedEvents());
        System.out.println("All tickets for user \"u2\":");
        System.out.println(ticketService.findAllTicketsByUser(u2));
    }
}
