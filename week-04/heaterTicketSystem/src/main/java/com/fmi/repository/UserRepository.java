package com.fmi.repository;

import com.fmi.model.User;
import lombok.NonNull;
import lombok.Setter;

import java.util.Map;

@Setter
public class UserRepository implements UserRepositoryInterface{
    Map<Long, User> idUser;

    @Override
    public void addUser(@NonNull User u) {
        Long id = u.getId();

        if(idUser.containsKey(id)){
            return;
        }

        idUser.put(id, u);
    }

    @Override
    public void deleteUser(Long id) {
        idUser.remove(id);
    }

    @Override
    public User findById(Long id) {
        return idUser.get(id);
    }

    @Override
    public void updateUser(@NonNull User user) {
        Long id = user.getId();

        if(!idUser.containsKey(id)){
            return;
        }

        deleteUser(id);
        idUser.put(id, user);
    }
}
