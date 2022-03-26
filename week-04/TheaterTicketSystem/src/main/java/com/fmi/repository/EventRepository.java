package com.fmi.repository;

import com.fmi.model.Event;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
public class EventRepository implements EventRepositoryInterface {
    private Map<Long, Event> idEvent;

    @Override
    public void createEvent(@NonNull Event event) {
        Long id = event.getEventId();

        if(idEvent.containsKey(id)){
            return;
        }

        idEvent.put(id, event);
    }

    @Override
    public void removeEvent(Long id) {
        idEvent.remove(id);
    }

    @Override
    public Event findById(Long id) {
        return idEvent.get(id);
    }

    @Override
    public void updateEvent(@NonNull Event event) {
        Long id = event.getEventId();

        if(!idEvent.containsKey(id)){
            return;
        }
        removeEvent(id);
        idEvent.put(id, event);
    }

    public List<Event> getAllEvents(){
        return new ArrayList<>(idEvent.values());
    }
}
