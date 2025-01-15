// QuizRepository.java
package com.quiz.iqquiz.repository;

import com.quiz.iqquiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
