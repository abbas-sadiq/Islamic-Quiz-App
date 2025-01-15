package com.quiz.iqquiz.service;

import com.quiz.iqquiz.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(Integer id);
    List<User> getAllUsers();
    User updateUser(Integer id, User user);
    Optional partialUpdate(Integer id, User userUpdates);
    void deleteUser(Integer id);
    List<User> saveAll(List<User> users);
}

