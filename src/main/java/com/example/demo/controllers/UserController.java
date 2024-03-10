package com.example.demo.controllers;

import com.example.demo.entities.MyUser;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public long saveUser(@RequestBody MyUser user){
       return userService.saveUser(user);
    }

    @GetMapping("/user/{id}")
    public Optional<MyUser> getUserById(@PathVariable("id") Long id){
        return  userService.getUserById(id);
    }
    @PutMapping("/user/{id}/update")
    public MyUser updateName(@PathVariable("id") long id, @RequestBody Map<String, String> updatedName) throws IllegalAccessException {
        String name = updatedName.get("name");

            return userService.updateUser(id, name);


    }
}
