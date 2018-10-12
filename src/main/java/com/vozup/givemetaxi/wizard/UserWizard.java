package com.vozup.givemetaxi.wizard;

import com.vozup.givemetaxi.entities.OperatorEntity;
import com.vozup.givemetaxi.entities.SiteManagersEntity;
import com.vozup.givemetaxi.enums.Roles;
import com.vozup.givemetaxi.repository.OperatorRepository;
import com.vozup.givemetaxi.repository.SiteManagersRepository;
import org.primefaces.event.FlowEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class UserWizard implements Serializable {
    private User user;
    private String newPassword;
    private String repeatNewPassword;
    private String answer;
    private Roles role;
    private String question;
    @Inject
    OperatorRepository operatorRepository;
    @Inject
    SiteManagersRepository managersRepository;
    private OperatorEntity operator;
    private SiteManagersEntity manager;

    @PostConstruct
    private void init() {
        user = new User();
    }

    public String onFlowProcess(FlowEvent event) {
        if (event.getNewStep().equals("question")) {
            if (role == Roles.ADMIN) {
                manager = managersRepository.findByLogin(user.getLogin());
                if (manager == null) {
                    showMessage("Login is incorect!");
                    return event.getOldStep();
                }
            } else if (role == Roles.USER) {
                operator = operatorRepository.findByLogin(user.getLogin());
                if (operator == null) {
                    showMessage("Login is incorect!");
                    return event.getOldStep();
                }
            }
            return event.getNewStep();
        }
        if (event.getNewStep().equals("password")) {
            if (manager != null) {
                if (manager.getQuestion() != null) {
                    if (manager.getAnswerOnSecretQuestion().equals(answer)) {
                        return event.getNewStep();
                    } else {
                        showMessage("Answer incorect");
                        return event.getOldStep();
                    }
                } else {
                    showMessage("Question is not attached, please call you'r admin");
                    return event.getOldStep();
                }
            } else if (operator != null) {
                if (operator.getQuestion() != null) {
                    if (operator.getAnswerOnSecretQuestion().equals(answer)) {
                        return event.getNewStep();
                    } else {
                        showMessage("Answer incorect");
                        return event.getOldStep();
                    }
                } else {
                    showMessage("Question is not attached, please call you'r admin");
                    return event.getOldStep();
                }
            } else {
                showMessage("Some error!");
                return event.getOldStep();
            }
        }
        return event.getNewStep();
    }

    public String getQuestion() {
        question = question();
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    private String question() {
        if (manager != null) {
            return manager.getQuestion().getQuestion();
        }
        if (operator != null) {
            return operator.getQuestion().getQuestion();
        }
        return null;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private void showMessage(String msg) {
        FacesMessage message = new FacesMessage(msg);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRepeatNewPassword() {
        return repeatNewPassword;
    }

    public void setRepeatNewPassword(String repeatNewPassword) {
        this.repeatNewPassword = repeatNewPassword;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
