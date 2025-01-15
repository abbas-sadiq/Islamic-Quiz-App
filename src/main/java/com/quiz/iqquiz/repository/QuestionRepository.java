package com.quiz.iqquiz.repository;

import com.quiz.iqquiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByQuizId(Integer quizId);

    @Query(value= "select q from Question q where q.id = :questionId and q.quiz.id = :quizId")
    Question findByQuestionIdAndQuizId(Integer questionId, Integer quizId);
}
