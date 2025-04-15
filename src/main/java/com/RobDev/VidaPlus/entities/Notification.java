package com.RobDev.VidaPlus.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String title;

    @Column(length = 350)
    private String message;

    private LocalDateTime momentEmail;

    @ManyToOne
    @JoinColumn(name = "patient")
    private Patient patient;

    public Notification(){}

    public Notification(long id, String title, String message, LocalDateTime momentEmail, Patient patient) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.momentEmail = momentEmail;
        this.patient = patient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDateTime getMomentEmail() {
        return momentEmail;
    }

    public void setMomentEmail(LocalDateTime momentEmail) {
        this.momentEmail = momentEmail;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
