package com.fmi.repository;

import com.fmi.model.User;

public interface UserRepositoryInterface {

    /**
     * Create new user
     */
    void addUser(User u);

    /**
     * Delete user
     */
    void deleteUser(Long id);

    /**
     * Find user by id
     */
    User findById(Long id);

    /**
     * Update user information
     */
    void updateUser(User user);
}
