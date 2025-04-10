package com.RobDev.VidaPlus.entities;

import com.RobDev.VidaPlus.entities.enums.Exam;
import com.RobDev.VidaPlus.entities.enums.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class MedicalExamination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private LocalDateTime examDate;
    private BigDecimal examFee;

    @Enumerated(value = EnumType.STRING)
    private Exam type;

    @Enumerated(value = EnumType.STRING)
    private Status status;
    private String result;

    @ManyToOne
    @JoinColumn(name = "consultation")
    private Consultation consultation;

    public MedicalExamination(){}

    public MedicalExamination(long id, String description, LocalDateTime examDate, BigDecimal examFee,
                              Exam type, Status status, String result, Consultation consultation) {
        this.id = id;
        this.description = description;
        this.examDate = examDate;
        this.type = type;
        this.status = status;
        this.result = result;
        this.consultation = consultation;
        this.examFee = examFee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDateTime examDate) {
        this.examDate = examDate;
    }

    public BigDecimal getExamFee() {
        return examFee;
    }

    public void setExamFee(BigDecimal examFee) {
        this.examFee = examFee;
    }

    public Exam getType() {
        return type;
    }

    public void setType(Exam type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalExamination that = (MedicalExamination) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
