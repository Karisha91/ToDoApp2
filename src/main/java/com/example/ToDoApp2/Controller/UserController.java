package com.example.ToDoApp2.Controller;

import com.example.ToDoApp2.Model.User;
import com.example.ToDoApp2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/ping")
    public String ping() {
        System.out.println("PING ENDPOINT HIT!");
        return "pong";
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // If password is still null here, the JSON was wrong or User class ignores it
        System.out.println("Received password: " + user.getPassword()); // Debug
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }
}
