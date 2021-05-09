package com.yoon.restapi1.controller;

import com.yoon.restapi1.model.User;
import com.yoon.restapi1.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final JpaUserRepository repository;

    @Autowired
    public UserController(JpaUserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id) {
        User user = repository.findById(id).get();

        return user;
    }

    @GetMapping("/user/all")
    public List<User> getAllUser() {
        List<User> result = repository.findAll();

        return result;
    }

    @PostMapping("/user")
    public String addUser(User user) {

        repository.save(user);

        return "redirect:/";
    }

    @PutMapping("/user/{id}")
    public String updateUser(@PathVariable("id") Long id, @RequestParam String name, @RequestParam String phone, @RequestParam String address) {

        User user1 = repository.findById(id).get();

        user1.setName(name);
        user1.setPhone(phone);
        user1.setAddress(address);

        repository.save(user1);

        return "redirect:/";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        repository.deleteById(id);

        return "redirect:/";
    }
}
