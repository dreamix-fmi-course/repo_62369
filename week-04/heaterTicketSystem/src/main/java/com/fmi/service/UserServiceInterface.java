package com.fmi.service;

import com.fmi.model.Event;
import com.fmi.model.User;

import java.util.List;

public interface UserServiceInterface {

    void createUser(User u);

    void deleteUser(Long id);

    User findById(Long id);

    void updateUserInformation(User user);

    /**
     * Return all visited events
     */
    List<Event> getAllVisitedEvents();

    /**
     * Return all visited events for the past month
     */
    List<Event> getAllVisitedEventsInPastMonth();
}
