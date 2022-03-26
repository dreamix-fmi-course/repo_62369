package com.fmi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.Objects;

@Data
@AllArgsConstructor
public class User {

    @NonNull
    private Long id;
    private String userName;
    private String email;

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof User)) {
            return false;
        }

        User u = (User) o;
        return Objects.equals(id, u.getId()) && Objects.equals(email, u.getEmail());
    }
}
