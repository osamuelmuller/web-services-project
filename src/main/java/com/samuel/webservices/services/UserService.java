package com.samuel.webservices.services;

import com.samuel.webservices.entities.User;
import com.samuel.webservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User create(User user) {
        return repository.save(user);
    }

    public User update(User newUser, Long id) {
        User oldUser = repository.getReferenceById(id);
        updateData(oldUser, newUser);
        return repository.save(oldUser);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private void updateData(User oldUser, User newUser) {
        oldUser.setName(newUser.getName());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setPhone(newUser.getPhone());
    }
}
