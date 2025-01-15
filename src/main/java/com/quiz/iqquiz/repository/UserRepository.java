package com.quiz.iqquiz.repository;


import com.quiz.iqquiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

