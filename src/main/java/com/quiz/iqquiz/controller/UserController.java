package com.quiz.iqquiz.controller;

import com.quiz.iqquiz.model.User;
import com.quiz.iqquiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    // Endpoint to add multiple users
    @PostMapping("/add-multiple")
    public ResponseEntity<List<User>> addUsers(@RequestBody List<User> users) {
        List<User> savedUsers = userService.saveAll(users);
        return ResponseEntity.ok(savedUsers);
    }

    @GetMapping("/getUser/{id}") // Fixed this line
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body(null)); // Return 404 if user not found
    }

    @GetMapping("/getUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<User> partialUpdateUser(@PathVariable Integer id, @RequestBody User userUpdates) {
        Optional<User> updatedUserOpt = userService.partialUpdate(id, userUpdates);
        return updatedUserOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body(null)); // Return 404 if user not found
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User with ID " + id + " has been deleted successfully!");
    }
}
