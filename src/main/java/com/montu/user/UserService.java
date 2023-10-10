package com.montu.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired private UserRepository repo;
    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }
    public User addUser(User user) {
        // Implement validation logic if needed
        return repo.save(user);
    }
    public User updateUser(Integer id, User user) {
        if (repo.existsById(id)) {
            user.setId(id); // Set the ID to ensure it's the correct user being updated
            return repo.save(user);
        } else {
            // Handle the case when the user with the given ID doesn't exist
            throw new com.example.exception.UserNotFoundException("User not found with id: " + id);
        }
    }
    public void deleteUser(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            // Handle the case when the user with the given ID doesn't exist
            throw new com.example.exception.UserNotFoundException("User not found with id: " + id);
        }
    }
}
