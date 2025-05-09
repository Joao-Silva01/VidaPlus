package com.RobDev.VidaPlus.entities;

import com.RobDev.VidaPlus.entities.enums.HealthProfession;
import com.RobDev.VidaPlus.entities.enums.UserRole;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class HealthProfessional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    @Column(nullable = false)
    private String password;

    private String document;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private HealthProfession profession;

    @Column(nullable = false)
    private String specialty;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    private Timestamp registerMoment;

    private String signature;

    @OneToMany(mappedBy = "professional")
    private List<Consultation> consultations = new ArrayList<>();

    @OneToMany(mappedBy = "professional")
    private List<UpdateLog> medicalRecords = new ArrayList<>();

    @OneToMany(mappedBy = "professional")
    private List<Agenda> scheduling = new ArrayList<>();

    public HealthProfessional() {
    }

    public HealthProfessional(Long id, String name, String email, String phone, String password, String document,
                              HealthProfession profession,
                              String specialty, UserRole role, Timestamp registerMoment,String signature) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.profession = profession;
        this.specialty = specialty;
        this.role = role;
        this.registerMoment = registerMoment;
        this.signature = signature;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public HealthProfession getProfession() {
        return profession;
    }

    public void setProfession(HealthProfession profession) {
        this.profession = profession;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public List<UpdateLog> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<UpdateLog> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public Timestamp getRegisterMoment() {
        return registerMoment;
    }

    public void setRegisterMoment(Timestamp registerMoment) {
        this.registerMoment = registerMoment;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public List<Agenda> getScheduling() {
        return scheduling;
    }

    public void setScheduling(List<Agenda> scheduling) {
        this.scheduling = scheduling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthProfessional that = (HealthProfessional) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
