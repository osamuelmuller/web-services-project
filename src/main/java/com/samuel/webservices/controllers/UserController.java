package com.samuel.webservices.controllers;

import com.samuel.webservices.entities.User;
import com.samuel.webservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> findAll() {
        List<User> list = service.findAll();
        return list;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        User user = service.findById(id);
        return user;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        user = service.create(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
}
