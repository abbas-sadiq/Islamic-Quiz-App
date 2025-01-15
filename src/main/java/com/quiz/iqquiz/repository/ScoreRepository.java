package com.quiz.iqquiz.repository;

import com.quiz.iqquiz.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, Integer> {

    Optional<Score> findByQuizIdAndUserId(Integer quizId, Integer userId);
}
