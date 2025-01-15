package com.quiz.iqquiz.service;

import com.quiz.iqquiz.dto.UserAnswerDTO;
import com.quiz.iqquiz.model.Question;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    Question saveQuestion(Question question);
    List<Question> saveQuestions(List<Question> questions);
    List<Question> getAllQuestions();
    Question getQuestionById(Integer id);
    Question updateQuestion(Integer id, Question question);
    void deleteQuestion(Integer id);
    List<Question> getQuestionsByQuizId(Integer quizId);
    void updateMultipleQuestions(List<Question> questions);
    void deleteAllQuestions();
    Question partialUpdateQuestion(Integer id, Map<String, Object> updates);
    void saveAnswer(UserAnswerDTO userAnswerDTO);
}

