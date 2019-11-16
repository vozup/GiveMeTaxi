package com.vozup.givemetaxi.entities;

import com.vozup.givemetaxi.enums.Roles;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "operator")
public class OperatorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String login;
    private String password;
    @Column(name = "answer")
    private String answerOnSecretQuestion;
    @OneToOne
    private QuestionsIfFogotPassword question;
    @OneToMany(mappedBy = "operator", fetch = FetchType.LAZY)
    private List<OrderEntity> orders;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 25)
    private Roles role;

    @PostConstruct
    private void init() {
        role = Roles.USER;
    }

    @Override
    public String toString() {
        return "OperatorEntity(" +
                "id=" + id +
                ", name= " + name +
                ", lastName= " + lastName +
                ", login= " + login +
                ", password= " + password +
                ')';
    }

    public String getAnswerOnSecretQuestion() {
        return answerOnSecretQuestion;
    }

    public void setAnswerOnSecretQuestion(String answerOnSecretQuestion) {
        this.answerOnSecretQuestion = answerOnSecretQuestion;
    }

    public QuestionsIfFogotPassword getQuestion() {
        return question;
    }

    public void setQuestion(QuestionsIfFogotPassword question) {
        this.question = question;
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

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
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
}
