package com.RobDev.VidaPlus.entities;

import com.RobDev.VidaPlus.entities.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String scheduledTask;
    private LocalDateTime taskDate;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    public Agenda(){}

    public Agenda(long id, String scheduledTask, LocalDateTime taskDate, Status status) {
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
