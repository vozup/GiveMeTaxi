package com.vozup.givemetaxi.entities;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class QuestionsIfFogotPassword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 512)
    private String question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
