package com.example.bookloan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.bookloan.model.User;
import com.example.bookloan.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //Enregistrer un nouveau utilisateur 
    public User createUser(User user){
        return userRepository.save(user);
    }

    //afficher la liste des utilisateurs
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //afficher un utilisateur s'il existe
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    //Supprimer un utilisateur s'il existe
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
