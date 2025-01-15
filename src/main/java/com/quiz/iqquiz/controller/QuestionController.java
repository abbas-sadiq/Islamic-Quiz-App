package com.quiz.iqquiz.controller;

import com.quiz.iqquiz.dto.UserAnswerDTO;
import com.quiz.iqquiz.model.Question;
import com.quiz.iqquiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/createQuestion")
    public Question addQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    @PostMapping("/addMultiple")
    public List<Question> addMultipleQuestions(@RequestBody List<Question> questions) {
        return questionService.saveQuestions(questions);
    }
    @GetMapping("/getQuestion")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }


    @GetMapping("/getQuestion/{id}")
    public Question getQuestionById(@PathVariable Integer id) {
        return questionService.getQuestionById(id);
    }

    @PutMapping("/updateQuestion/{id}")
    public Question updateQuestion(@PathVariable Integer id, @RequestBody Question question) {
        return questionService.updateQuestion(id, question);
    }
    @PutMapping("/updateMultiple")
    public void updateMultipleQuestions(@RequestBody List<Question> questions) {
        questionService.updateMultipleQuestions(questions);
    }

    @PatchMapping("/{id}")
    public Question partialUpdateQuestion(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        return questionService.partialUpdateQuestion(id, updates);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Integer id) {
        questionService.deleteQuestion(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllQuestions() {
        questionService.deleteAllQuestions();
    }


    @GetMapping("/quiz{quizId}")
    public List<Question> getQuestionsByQuizId(@PathVariable Integer quizId) {
        return questionService.getQuestionsByQuizId(quizId);
    }


    @PostMapping("/getUserAnswer")
    public ResponseEntity<String> getUserAnswer(@RequestBody UserAnswerDTO userAnswerDTO) {
        questionService.saveAnswer(userAnswerDTO);
        return ResponseEntity.ok("Answer saved successfully");
    }
}
