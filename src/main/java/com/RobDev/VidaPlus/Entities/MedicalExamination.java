package com.RobDev.VidaPlus.Entities;

import com.RobDev.VidaPlus.Entities.Enums.Exam;
import com.RobDev.VidaPlus.Entities.Enums.Status;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class MedicalExamination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private Timestamp examDate;

    @Enumerated(value = EnumType.STRING)
    private Exam type;

    @Enumerated(value = EnumType.STRING)
    private Status status;
    private String result;

    public MedicalExamination(){}

    public MedicalExamination(long id, String description, Timestamp examDate, Exam type, Status status, String result) {
        this.id = id;
        this.description = description;
        this.examDate = examDate;
        this.type = type;
        this.status = status;
        this.result = result;
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

    public Timestamp getExamDate() {
        return examDate;
    }

    public void setExamDate(Timestamp examDate) {
        this.examDate = examDate;
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
