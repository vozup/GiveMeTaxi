package com.vozup.givemetaxi.wizard;


public class User {
    private String login;
    private String answerOnQuestion;
    private String newPassword;

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAnswerOnQuestion() {
        return answerOnQuestion;
    }

    public void setAnswerOnQuestion(String answerOnQuestion) {
        this.answerOnQuestion = answerOnQuestion;
    }

}
