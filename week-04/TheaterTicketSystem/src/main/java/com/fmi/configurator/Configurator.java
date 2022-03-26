package com.fmi.configurator;

import com.fmi.model.Event;
import com.fmi.model.Ticket;
import com.fmi.model.User;
import com.fmi.repository.EventRepository;
import com.fmi.repository.TicketRepository;
import com.fmi.repository.UserRepository;
import com.fmi.service.EventService;
import com.fmi.service.TicketService;
import com.fmi.service.UserService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class Configurator {
    @Bean
    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public User user() {
        return new User(0L, "Default", "default@fedault.defult");
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public User userMe() {
        return new User(489L, "Andrey Stoev", "andrey.s@abv.bg");
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public User userPesho() {
        return new User(123L, "Pesho Peshov", "pesho_no_drama.s@gmail.com");
    }

    @Bean
    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Ticket ticket() {
        return new Ticket(0L, new BigDecimal("0"), 0, 0, user(), event());
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Ticket ticketHackathonMe() {
        return new Ticket(3456L, new BigDecimal("20.00"), 4, 16, userMe(), eventHackathon());
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Ticket ticketHackathonPesho() {
        return new Ticket(3456L, new BigDecimal("20.00"), 4, 16, userPesho(), eventHackathon());
    }

    @Bean
    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Event event() {
        return new Event(0L, "Default event", LocalDateTime.now(), "Default description");
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Event eventHackathon() {
        return new Event(1234L, "Hackathon", LocalDateTime.now().plusDays(20),
                "FMI Hackathon");
    }

    @Bean
    public EventRepository eventRepository() {
        EventRepository eventRepo = new EventRepository();
        eventRepo.setIdEvent(new ConcurrentHashMap<>());

        return eventRepo;
    }

    @Bean
    public TicketRepository ticketRepository() {
        TicketRepository ticketRepo = new TicketRepository();
        ticketRepo.setIdTicket(new ConcurrentHashMap<>());

        return ticketRepo;
    }

    @Bean
    public UserRepository userRepository() {
        UserRepository userRepo = new UserRepository();
        userRepo.setIdUser(new ConcurrentHashMap<>());

        return userRepo;
    }

    @Bean
    public EventService eventService() {
        return new EventService(eventRepository());
    }

    @Bean
    public TicketService ticketService() {
        return new TicketService( eventRepository(), ticketRepository());
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository(), ticketRepository());
    }

}
