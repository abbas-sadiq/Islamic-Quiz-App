package com.quiz.iqquiz.controller;

import com.quiz.iqquiz.model.Quiz;
import com.quiz.iqquiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/createQuiz")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz savedQuiz = quizService.saveQuiz(quiz);
        return ResponseEntity.ok(savedQuiz);
    }

    @GetMapping("/getAllQuiz")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }

    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Integer id) {
        Optional<Quiz> quiz = quizService.getQuizById(id);
        return quiz.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updateQuiz/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Integer id, @RequestBody Quiz quizDetails) {
        Optional<Quiz> updatedQuiz = quizService.updateQuiz(id, quizDetails);
        return updatedQuiz.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteQuiz/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Integer id) {
        boolean isDeleted = quizService.deleteQuiz(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
