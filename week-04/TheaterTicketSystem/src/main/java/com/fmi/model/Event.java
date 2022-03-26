package com.fmi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Event {

    @NonNull
    private Long eventId;
    private String name;
    private LocalDateTime date;
    private String description;

    @Override
    public int hashCode() {
        return Objects.hash(eventId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Event)) {
            return false;
        }

        Event e = (Event) o;
        return Objects.equals(eventId, e.getEventId());
    }
}
