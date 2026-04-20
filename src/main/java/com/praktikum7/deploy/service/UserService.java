package com.praktikum7.deploy.service;

import com.praktikum7.deploy.model.User;
import com.praktikum7.deploy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User request) {
        request.setId(UUID.randomUUID().toString());
        return userRepository.save(request);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(String id, User request) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(request.getName());
            user.setNim(request.getNim());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
