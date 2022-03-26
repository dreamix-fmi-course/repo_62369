package com.fmi.service;

import com.fmi.model.Event;

public interface EventServiceInterface {
    void createEvent(Event u);

    void removeEvent(Long id);

    Event findById(Long id);

    void updateEvent(Event event);
}
