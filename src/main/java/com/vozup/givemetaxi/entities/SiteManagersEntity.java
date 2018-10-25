package com.vozup.givemetaxi.entities;

import com.vozup.givemetaxi.enums.Roles;

import javax.annotation.PostConstruct;
import javax.persistence.*;

@Entity
@Table(name = "siteManagers", schema = "schema")
public class SiteManagersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;
    private String name;
    @OneToOne
    private QuestionsIfFogotPassword question;
    @Column(name = "answer")
    private String answerOnSecretQuestion;
    private String lastName;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 25)
    private Roles role;

    @PostConstruct
    private void init() {
        role = Roles.ADMIN;
    }

    public SiteManagersEntity() {
    }

    public SiteManagersEntity(SiteManagersEntity sm) {
        this.id = sm.getId();
        this.login = sm.getLogin();
        this.password = sm.getPassword();
        this.name = sm.getName();
        this.lastName = sm.getLastName();
        this.role = sm.getRole();
        this.question = sm.getQuestion();
        this.answerOnSecretQuestion = sm.getAnswerOnSecretQuestion();
    }

    public QuestionsIfFogotPassword getQuestion() {
        return question;
    }

    public void setQuestion(QuestionsIfFogotPassword question) {
        this.question = question;
    }

    public String getAnswerOnSecretQuestion() {
        return answerOnSecretQuestion;
    }

    public void setAnswerOnSecretQuestion(String answerOnSecretQuestion) {
        this.answerOnSecretQuestion = answerOnSecretQuestion;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
