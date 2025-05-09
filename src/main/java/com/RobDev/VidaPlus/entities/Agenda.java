package com.RobDev.VidaPlus.entities;

import com.RobDev.VidaPlus.entities.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String scheduledTask;
    private LocalDateTime taskDate;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "professional")
    private HealthProfessional professional;

    public Agenda(){}

    public Agenda(long id, String scheduledTask, LocalDateTime taskDate, Status status, HealthProfessional professional) {
        this.id = id;
        this.scheduledTask = scheduledTask;
        this.taskDate = taskDate;
        this.status = status;
        this.professional = professional;
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

    public HealthProfessional getProfessional() {
        return professional;
    }

    public void setProfessional(HealthProfessional professional) {
        this.professional = professional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agenda agenda = (Agenda) o;
        return id == agenda.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
