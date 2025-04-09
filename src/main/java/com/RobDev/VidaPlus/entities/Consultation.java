package com.RobDev.VidaPlus.entities;

import com.RobDev.VidaPlus.entities.enums.Modality;
import com.RobDev.VidaPlus.entities.enums.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date consultationMoment;
    private String diagnostic;
    private String symptoms;

    @Column(scale = 10, precision = 2)
    private BigDecimal ConsultationFee;
    private String consultationLink;

    @Enumerated(value = EnumType.STRING)
    private Modality type;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "patient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "professional")
    private HealthProfessional professional;

    @OneToOne(mappedBy = "consultation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Prescription prescription;

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalExamination> requestedExams = new ArrayList<>();

    @OneToOne(mappedBy = "consultation", cascade = CascadeType.ALL, orphanRemoval = true)
    private HospitalAdmission hospitalization;

    public Consultation(){}

    public Consultation(Long id, Date consultationMoment, String diagnostic, String symptoms, BigDecimal consultationFee,
                        String consultationLink, Modality type, Status status, Patient patient, HealthProfessional professional,
                        Prescription prescription, HospitalAdmission hospitalization) {
        this.id = id;
        this.consultationMoment = consultationMoment;
        this.diagnostic = diagnostic;
        this.symptoms = symptoms;
        ConsultationFee = consultationFee;
        this.consultationLink = consultationLink;
        this.type = type;
        this.status = status;
        this.patient = patient;
        this.professional = professional;
        this.prescription = prescription;
        this.hospitalization = hospitalization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getConsultationMoment() {
        return consultationMoment;
    }

    public void setConsultationMoment(Date consultationMoment) {
        this.consultationMoment = consultationMoment;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public BigDecimal getConsultationFee() {
        return ConsultationFee;
    }

    public void setConsultationFee(BigDecimal consultationFee) {
        ConsultationFee = consultationFee;
    }

    public Modality getType() {
        return type;
    }

    public void setType(Modality type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getConsultationLink() {
        return consultationLink;
    }

    public void setConsultationLink(String consultationLink) {
        this.consultationLink = consultationLink;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public HealthProfessional getProfessional() {
        return professional;
    }

    public void setProfessional(HealthProfessional professional) {
        this.professional = professional;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public List<MedicalExamination> getRequestedExams() {
        return requestedExams;
    }

    public void setRequestedExams(List<MedicalExamination> requestedExams) {
        this.requestedExams = requestedExams;
    }

    public void addRequestedExams(MedicalExamination requestedExam) {
        this.requestedExams.add(requestedExam);
    }

    public HospitalAdmission getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(HospitalAdmission hospitalization) {
        this.hospitalization = hospitalization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultation that = (Consultation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
