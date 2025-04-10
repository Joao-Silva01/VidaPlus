package com.RobDev.VidaPlus.entities;

import com.RobDev.VidaPlus.entities.enums.Sex;
import com.RobDev.VidaPlus.entities.enums.UserRole;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Timestamp birth_date;
    private String phone;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Sex sex;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String document;

    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    private Timestamp registerMoment;

    @OneToMany(mappedBy = "patient")
    private List<Consultation> consultations = new ArrayList<>();

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private MedicalRecord medicalRecord;

    public Patient() {
    }

    public Patient(Long id, String name, Timestamp birthDate, Sex sex, String password, String email,
                   String phone, String document, UserRole role, Timestamp registerMoment) {
        this.id = id;
        this.name = name;
        this.birth_date = birthDate;
        this.sex = sex;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.document = document;
        this.role = role;
        this.registerMoment = registerMoment;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Timestamp getRegisterMoment() {
        return registerMoment;
    }

    public void setRegisterMoment(Timestamp registerMoment) {
        this.registerMoment = registerMoment;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
