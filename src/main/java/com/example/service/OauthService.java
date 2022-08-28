package com.example.service;


import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class OauthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User saveUser(@RequestBody User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if(userFromDb != null)

        {
            model.put("message", "User exists");
            return user;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Integer deleteBook(Integer id) {
        userRepository.deleteById(id);
        return id;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

}
