package com.quiz.iqquiz.dto;

public class UserAnswerDTO {
    private int userId;
    private int quizId;
    private int questionId;
    private String selectedOption;

    public UserAnswerDTO() {
    }

    public UserAnswerDTO(int userId, int quizId, int questionId, String selectedOption) {
        this.userId = userId;
        this.quizId = quizId;
        this.questionId = questionId;
        this.selectedOption = selectedOption;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }
}
