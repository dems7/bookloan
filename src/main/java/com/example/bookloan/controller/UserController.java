package com.example.bookloan.controller;

import com.example.bookloan.model.User;
//import com.example.bookloan.repository.UserRepository;
import com.example.bookloan.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    
    public UserController (UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        Optional<User> optionalUser = userService.getUserById(id);

    if (optionalUser.isPresent()) {
        return ResponseEntity.ok(optionalUser.get());
    } else {
        return ResponseEntity.status(404).body("Utilisateur introuvable");
    }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.ok("Utilisateur supprimé.");
        } else {
            return ResponseEntity.status(404).body("Utilisateur introuvable.");
        }
    }
    
}
