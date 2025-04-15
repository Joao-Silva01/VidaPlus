package com.RobDev.VidaPlus.dto.notification;

import com.RobDev.VidaPlus.entities.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class NotificationResponse {

    private long id;
    private String title;
    private String message;

    @JsonFormat( pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime momentEmail;

    public NotificationResponse() {
    }

    public NotificationResponse(long id, LocalDateTime momentEmail, String title, String message) {
        this.id = id;
        this.momentEmail = momentEmail;
        this.title = title;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getMomentEmail() {
        return momentEmail;
    }

    public void setMomentEmail(LocalDateTime momentEmail) {
        this.momentEmail = momentEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
