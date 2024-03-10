package com.example.demo.services;

import com.example.demo.entities.MyUser;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public long saveUser(MyUser user){
       return userRepository.save(user).getId();

    }
    public Optional<MyUser> getUserById(Long id){
            return userRepository.findById(id);
    }
    public MyUser updateUser(long id, String name) throws IllegalAccessException {
       Optional< MyUser> optionalUser = getUserById(id);
        if(optionalUser.isPresent()){
            MyUser user = optionalUser.get();
            user.setName(name);
            userRepository.save(user);
            return user;

        }else{
            throw new IllegalAccessException("User with id " + id + " doesn't exist");
        }


    }
}
