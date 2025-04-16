package com.RobDev.VidaPlus.dto.agenda;


import com.RobDev.VidaPlus.entities.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class AgendaRequest {

    @NotBlank(message = "Task cannot be empty or null")
    @Size(max = 200, message = "invalid task size")
    private String scheduledTask;

    @NotNull(message = "Date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime taskDate;

    @NotNull(message = "Status cannot be null")
    private Status status;

    public AgendaRequest(){

    }

    public AgendaRequest(String scheduledTask, LocalDateTime taskDate, Status status) {
        this.scheduledTask = scheduledTask;
        this.taskDate = taskDate;
        this.status = status;
    }

    public String getScheduledTask() {
        return scheduledTask;
    }

    public void setScheduledTask( String scheduledTask) {
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
