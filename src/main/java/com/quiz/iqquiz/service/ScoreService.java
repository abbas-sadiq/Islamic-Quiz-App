package com.quiz.iqquiz.service;

import com.quiz.iqquiz.model.Score;
import java.util.List;

public interface ScoreService {
    Score saveScore(Score score);
    List<Score> getAllScores();
    Score getScoreById(Integer id);
    void deleteScore(Integer id);
    Score updateScore(Integer quizId, Integer userId, boolean isAnswerCorrect);
    Score getScoreByQuizIdAndUserId(Integer quizId, Integer userId);
}
