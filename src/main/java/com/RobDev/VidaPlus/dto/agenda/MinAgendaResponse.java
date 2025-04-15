package com.RobDev.VidaPlus.dto.agenda;

import com.RobDev.VidaPlus.entities.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

// Usado como resposta reduzida da Agenda, tirando a referencia ao profissional
public class MinAgendaResponse {

    private long id;
    private String scheduledTask;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime taskDate;
    private Status status;

    public MinAgendaResponse(){

    }

    public MinAgendaResponse(long id, String scheduledTask, LocalDateTime taskDate, Status status) {
        this.id = id;
        this.scheduledTask = scheduledTask;
        this.taskDate = taskDate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getScheduledTask() {
        return scheduledTask;
    }

    public void setScheduledTask(String scheduledTask) {
        this.scheduledTask = scheduledTask;
    }

    public LocalDateTime getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDateTime taskDate) {
        this.taskDate = taskDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
