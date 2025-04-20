package com.RobDev.VidaPlus.dto.notification;

import jakarta.validation.constraints.NotBlank;

public class NotificationRequest {

    @NotBlank(message = "Title cannot be empty or null")
    private String title;
    @NotBlank(message = "Message cannot be empty or null")
    private String message;

    public NotificationRequest(){

    }

    public NotificationRequest(String title, String message) {
        this.title = title;
        this.message = message;
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
