package com.montu.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api")
public class UserController {
    @Autowired private UserService service;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return service.listAll();
    }
    @PostMapping("/users/create")
    public User createNewUser(@RequestBody User user){
            return service.addUser(user);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        User updatedUser = service.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable Integer id) {
        Map<String, String> response = new HashMap<>();
        try {

            service.deleteUser(id);
            response.put("success", "true");
            response.put("message", "User with ID " + id + " has been deleted.");
            return ResponseEntity.ok(response);
        } catch (com.example.exception.UserNotFoundException e) {
            response.put("success", "false");
            response.put("message", "User with ID " + id + " doesn't exists.");
            return ResponseEntity.status(404).body(response);
        }
    }
}
