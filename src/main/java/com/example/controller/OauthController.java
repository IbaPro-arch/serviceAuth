package com.example.controller;

import com.example.entity.User;
import com.example.service.OauthService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class OauthController {

    @Autowired
    OauthService oauthService;

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", oauthService.allUsers());
        return "admin";
    }

    @DeleteMapping("/admin/{bookId}")
    public void deleteBook(@PathVariable Integer bookId) {
        oauthService.deleteBook(bookId);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user, Map<String, Object> model) {
        return oauthService.saveUser(user, model);
    }
}