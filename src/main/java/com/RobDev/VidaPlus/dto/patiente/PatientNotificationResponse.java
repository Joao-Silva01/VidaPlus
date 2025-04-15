package com.RobDev.VidaPlus.dto.patiente;

import com.RobDev.VidaPlus.dto.notification.NotificationResponse;
import com.RobDev.VidaPlus.entities.enums.Sex;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

// usado como resposta, serve para mostrar todas as notificação que o paciente recebeu
public class PatientNotificationResponse {

    private Long id;
    private String name;

    @JsonFormat( pattern = "yyyy-MM-dd HH:mm")
    private Timestamp birth_date;
    private String phone;
    private Sex sex;
    private String email;
    private String document;

    private List<NotificationResponse> notifications = new ArrayList<>();

    public PatientNotificationResponse() {
    }

    public PatientNotificationResponse(Long id, String name,
                                       Timestamp birth_date,
                                       String phone, Sex sex,
                                       String email, String document) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.phone = phone;
        this.sex = sex;
        this.email = email;
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Timestamp birth_date) {
        this.birth_date = birth_date;
    }

    public String getPhone() {
        // Retorna o número formatado com espaço
        return phone.replaceFirst("(\\d{2})(\\d{9})", "$1 $2");
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        //retorna o cpf formatado '111.111.111-11'
        return document.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public List<NotificationResponse> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationResponse> notifications) {
        this.notifications = notifications;
    }
}
