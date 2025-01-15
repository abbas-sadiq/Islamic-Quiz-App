package com.quiz.iqquiz.service.impl;

import com.quiz.iqquiz.model.Quiz;
import com.quiz.iqquiz.model.Score;
import com.quiz.iqquiz.model.User;
import com.quiz.iqquiz.repository.QuizRepository;
import com.quiz.iqquiz.repository.ScoreRepository;
import com.quiz.iqquiz.repository.UserRepository;
import com.quiz.iqquiz.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuizRepository quizRepository;


    @Override
    public Score saveScore(Score score) {
        return scoreRepository.save(score);
    }

    @Override
    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    @Override
    public Score getScoreById(Integer id) {
        return scoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Score not found with id: " + id));
    }

    @Override
    public Score getScoreByQuizIdAndUserId(Integer quizId, Integer userId) {
        Optional<Score> optionalScore = scoreRepository.findByQuizIdAndUserId(quizId, userId);
    return optionalScore.isPresent() ? optionalScore.get() : null;
    }

    @Override
    public Score updateScore(Integer quizId, Integer userId, boolean isAnswerCorrect) {

        Optional<Score> optionalScore = scoreRepository.findByQuizIdAndUserId(quizId, userId);
        Score score;

        if (optionalScore.isEmpty()) {
            score = new Score();
            score.setCorrectAnswers(0);
        } else {
            score = optionalScore.get();
        }

        Optional<User> user = userRepository.findById(userId);
        Optional<Quiz> quiz = quizRepository.findById(quizId);

        score.setUser(user.get());
        score.setQuiz(quiz.get());
        if (isAnswerCorrect) {
            score.setCorrectAnswers(score.getCorrectAnswers() + 1);
        } else {
            score.setCorrectAnswers(score.getCorrectAnswers() - 1);
        }
       return scoreRepository.save(score);
    }

    @Override
    public void deleteScore(Integer id) {
        scoreRepository.deleteById(id);
    }
}
