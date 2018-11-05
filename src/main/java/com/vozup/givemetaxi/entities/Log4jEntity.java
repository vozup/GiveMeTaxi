package com.vozup.givemetaxi.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "logs", schema = "schema")
public class Log4jEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String level;
    private String logger;
    @Column(length = 2048)
    private String message;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
