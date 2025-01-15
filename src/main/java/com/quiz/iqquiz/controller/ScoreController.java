package com.quiz.iqquiz.controller;

import com.quiz.iqquiz.model.Score;
import com.quiz.iqquiz.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    // Add a new score
    @PostMapping()
    public Score addScore(@RequestBody Score score) {
        return scoreService.saveScore(score);
    }

    // Get all scores
    @GetMapping()
    public List<Score> getAllScores() {
        return scoreService.getAllScores();
    }

    // Get a score by ID
    @GetMapping("/{id}")
    public Score getScoreById(@PathVariable Integer id) {
        return scoreService.getScoreById(id);
    }

    // Delete a score
    @DeleteMapping("/{id}")
    public void deleteScore(@PathVariable Integer id) {
        scoreService.deleteScore(id);
    }

    @GetMapping("/user/{userId}")
    public Score findByQuizIdAndUserId(@RequestParam Integer quizId, @PathVariable Integer userId) {
        return scoreService.getScoreByQuizIdAndUserId(quizId, userId);

    }
}
