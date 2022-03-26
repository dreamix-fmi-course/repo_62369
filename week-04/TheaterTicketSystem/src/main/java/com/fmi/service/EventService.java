package com.fmi.service;

import com.fmi.model.Event;
import com.fmi.repository.EventRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class EventService implements EventServiceInterface {
    @Autowired
    private EventRepository eventRepo;

    @Override
    public void createEvent(Event u) {
        eventRepo.createEvent(u);
    }

    @Override
    public void removeEvent(Long id) {
        eventRepo.removeEvent(id);
    }

    @Override
    public Event findById(Long id) {
        return eventRepo.findById(id);
    }

    @Override
    public void updateEvent(Event event) {
        eventRepo.updateEvent(event);
    }
}
