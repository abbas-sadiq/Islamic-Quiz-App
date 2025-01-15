package com.quiz.iqquiz.service.impl;

import com.quiz.iqquiz.dto.UserAnswerDTO;
import com.quiz.iqquiz.model.Category;
import com.quiz.iqquiz.model.Question;
import com.quiz.iqquiz.model.Quiz;
import com.quiz.iqquiz.repository.CategoryRepository;
import com.quiz.iqquiz.repository.QuestionRepository;
import com.quiz.iqquiz.repository.QuizRepository;
import com.quiz.iqquiz.service.QuestionService;
import com.quiz.iqquiz.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ScoreService scoreService;

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> saveQuestions(List<Question> questions) {
        return questionRepository.saveAll(questions);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Integer id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
    }

    @Override
    public Question updateQuestion(Integer id, Question questionDetails) {
        Question question = getQuestionById(id);
        question.setText(questionDetails.getText());
        question.setCorrectOption(questionDetails.getCorrectOption()); // Updated field
        question.setOptionA(questionDetails.getOptionA());
        question.setOptionB(questionDetails.getOptionB());
        question.setOptionC(questionDetails.getOptionC());
        question.setOptionD(questionDetails.getOptionD());
        question.setQuiz(questionDetails.getQuiz());
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> getQuestionsByQuizId(Integer quizId) {
        return questionRepository.findByQuizId(quizId);
    }

    @Override
    public void updateMultipleQuestions(List<Question> questions) {
        for (Question question : questions) {
            if (question.getId()!= 0) {
                Optional<Question> existingQuestion = questionRepository.findById(question.getId());
                if (existingQuestion.isPresent()) {
                    Question updatedQuestion = existingQuestion.get();
                    updatedQuestion.setText(question.getText());
                    updatedQuestion.setCorrectOption(question.getCorrectOption()); // Updated field
                    updatedQuestion.setOptionA(question.getOptionA());
                    updatedQuestion.setOptionB(question.getOptionB());
                    updatedQuestion.setOptionC(question.getOptionC());
                    updatedQuestion.setOptionD(question.getOptionD());
                    updatedQuestion.setQuiz(question.getQuiz());
                    questionRepository.save(updatedQuestion);
                }
            }
        }
    }

    @Override
    public void deleteAllQuestions() {
        questionRepository.deleteAll();
    }

    // Partial update method
    @Override
    public Question partialUpdateQuestion(Integer id, Map<String, Object> updates) {
        Question question = getQuestionById(id);

        if (updates.containsKey("text")) {
            question.setText((String) updates.get("text"));
        }
        if (updates.containsKey("correctOption")) { // Updated field
            question.setCorrectOption((String) updates.get("correctOption"));
        }
        if (updates.containsKey("optionA")) {
            question.setOptionA((String) updates.get("optionA"));
        }
        if (updates.containsKey("optionB")) {
            question.setOptionB((String) updates.get("optionB"));
        }
        if (updates.containsKey("optionC")) {
            question.setOptionC((String) updates.get("optionC"));
        }
        if (updates.containsKey("optionD")) {
            question.setOptionD((String) updates.get("optionD"));
        }

        if (updates.containsKey("quiz_id")) {
            Integer quizId = (Integer) updates.get("quiz_id");
            Optional<Quiz> quiz = quizRepository.findById(quizId);
            quiz.ifPresent(question::setQuiz);
        }

        return questionRepository.save(question);
    }

    public void saveAnswer(UserAnswerDTO userAnswerDTO) {

        Question question = questionRepository.findByQuestionIdAndQuizId(userAnswerDTO.getQuestionId(), userAnswerDTO.getQuizId());

            scoreService.updateScore(userAnswerDTO.getQuizId(), userAnswerDTO.getUserId(), userAnswerDTO.getSelectedOption().equalsIgnoreCase(question.getCorrectOption()));
    }
}
