// QuizServiceImpl.java
package com.quiz.iqquiz.service.impl;

import com.quiz.iqquiz.model.Quiz;
import com.quiz.iqquiz.repository.QuizRepository;
import com.quiz.iqquiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public Optional<Quiz> getQuizById(Integer id) {
        return quizRepository.findById(id);
    }

    @Override
    public Optional<Quiz> updateQuiz(Integer id, Quiz quizDetails) {
        return quizRepository.findById(id).map(existingQuiz -> {
            existingQuiz.setTitle(quizDetails.getTitle());
            return quizRepository.save(existingQuiz);
        });
    }

    @Override
    public boolean deleteQuiz(Integer id) {
        if (quizRepository.existsById(id)) {
            quizRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
