package com.quiz.iqquiz.service.impl;

import com.quiz.iqquiz.model.User;
import com.quiz.iqquiz.repository.UserRepository;
import com.quiz.iqquiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> saveAll(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Integer id, User user) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setUsername(user.getUsername());
                    existingUser.setPassword(user.getPassword());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setCity(user.getCity());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Override
    public Optional<User> partialUpdate(Integer id, User userUpdates) {
        Optional<User> existingUserOpt = userRepository.findById(id);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();

            if (userUpdates.getUsername() != null) {
                existingUser.setUsername(userUpdates.getUsername());
            }
            if (userUpdates.getEmail() != null) {
                existingUser.setEmail(userUpdates.getEmail());
            }
            if (userUpdates.getCity() != null) {
                existingUser.setCity(userUpdates.getCity());
            }
            // Save and return the updated user
            return Optional.of(userRepository.save(existingUser));
        }
        // Return Optional.empty() if user is not found
        return Optional.empty();
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
