package com.RobDev.VidaPlus.dto.medicalExamination;

import com.RobDev.VidaPlus.entities.enums.Exam;
import com.RobDev.VidaPlus.entities.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;

public class CreateExamRequest {

    @Size(max = 255 ,message = "invalid description size")
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "America/Sao_Paulo")
    private Timestamp examDate;
    private Exam type;
    private Status status;

    @Size(max = 250 , message = "invalid result size")
    private String result;

    public CreateExamRequest() {
    }

    public CreateExamRequest(String description, Timestamp examDate, Exam type, Status status, String result) {
        this.description = description;
        this.examDate = examDate;
        this.type = type;
        this.status = status;
        this.result = result;
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
}
