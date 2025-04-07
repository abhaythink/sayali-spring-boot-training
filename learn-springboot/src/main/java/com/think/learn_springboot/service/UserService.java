package com.think.learn_springboot.service;

import com.think.learn_springboot.entity.User;
import com.think.learn_springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public  List<User> getAllUsers(){

        return userRepository.findAll();
    }
    
    public Optional<User> getUser(int id) {
    Optional<User> user = userRepository.findById(id);
    
    if (user.isPresent()) {
        return user;
    } else {
        System.out.println("No user found with ID: " + id);
        return Optional.empty();
    }
}


    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(int id, User user) {
        Optional<User> userOptional = getUser(id);

        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setName(user.getName());
            existingUser.setCity(user.getCity());

            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }


    public  void removeUser(int id) {
        Optional<User> user = getUser(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw  new RuntimeException("User is not present");
        }
    }

}
