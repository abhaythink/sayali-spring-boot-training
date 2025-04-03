package com.think.learn_springboot.controller;

import com.think.learn_springboot.entity.User;
import com.think.learn_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

        @Autowired
        UserService userService;

        @GetMapping("/users")
        public List<User> getAllUsers(){

            return userService.getAllUsers();
        }
        
        @GetMapping("/users/{id}")
        public Optional<User> getUser(@PathVariable int id){

            return userService.getUser(id);
        }    
        
        @PostMapping("/users")
        public User createUser(@RequestBody User user) {
            User savedUser = userService.createUser(user);
            return savedUser;
        }

        @PutMapping("/users/{id}")
        public User updateUser(@PathVariable int id, @RequestBody User user) {
            User updatesUser = userService.updateUser(id,user);
            return  updatesUser;
        }

        @DeleteMapping("/users/{id}")
        public  void deleteUser(@PathVariable int id){
            userService.removeUser(id);
        }

}
