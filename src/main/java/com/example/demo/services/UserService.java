package com.example.demo.services;

import com.example.demo.entities.MyUser;
import com.example.demo.exeptions.UserNotFoundException;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public long saveUser(MyUser user) {
        return userRepository.save(user).getId();

    }

    public MyUser getUserById(Long id) {
        Optional<MyUser> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User with id " + id + " doesn't exist");
        }

    }

    public MyUser updateUser(long id, String name) {

        Optional<MyUser> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            MyUser user = userOptional.get();
            user.setName(name);
            userRepository.save(user);
            return user;
        } else {
            throw new UserNotFoundException("User with id " + id + " doesn't exist");
        }


    }
}
