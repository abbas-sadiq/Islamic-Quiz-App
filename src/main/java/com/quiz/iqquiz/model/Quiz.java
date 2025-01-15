package com.quiz.iqquiz.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Quiz implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private int totalQuestions;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Question> questions;

    public Quiz() {
    }

    public Quiz(Integer id, String title, int totalQuestions, Category category, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.totalQuestions = totalQuestions;
        this.category = category;
        this.questions = questions;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }
    public void updateTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
