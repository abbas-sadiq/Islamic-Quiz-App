// QuizService.java
package com.quiz.iqquiz.service;

import com.quiz.iqquiz.model.Quiz;
import java.util.List;
import java.util.Optional;

public interface QuizService {
    Quiz saveQuiz(Quiz quiz);
    List<Quiz> getAllQuizzes();
    Optional<Quiz> getQuizById(Integer id);
    Optional<Quiz> updateQuiz(Integer id, Quiz quizDetails);
    boolean deleteQuiz(Integer id);
}
