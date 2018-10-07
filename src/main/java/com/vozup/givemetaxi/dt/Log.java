package com.vozup.givemetaxi.dt;


import com.vozup.givemetaxi.entities.Log4jEntity;
import com.vozup.givemetaxi.repository.LogsRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("dtLog")
public class Log {
    private List<Log4jEntity> logs;
    @Inject
    private LogsRepository repository;

    public List<Log4jEntity> getLogs() {
        logs = repository.findAll();
        return logs;
    }

    public void setLogs(List<Log4jEntity> logs) {
        this.logs = logs;
    }
}
