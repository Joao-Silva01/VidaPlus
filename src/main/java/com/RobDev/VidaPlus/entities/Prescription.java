package com.RobDev.VidaPlus.entities;

import com.RobDev.VidaPlus.entities.enums.Modality;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 350)
    private String description;

    @Column(nullable = false)
    private LocalDateTime prescriptionDate;

    @Column(nullable = false, length = 9)
    @Enumerated(value = EnumType.STRING)
    private Modality type;

    @Column(nullable = false, length = 100)
    private String signature;

    @OneToOne
    @JoinColumn(name = "consultation", unique = true)
    private Consultation consultation;

    public Prescription(){

    }

    public Prescription(long id, String description, LocalDateTime prescriptionDate,
                        Modality type, String signature,
                        Consultation consultation) {
        this.id = id;
        this.description = description;
        this.prescriptionDate = prescriptionDate;
        this.type = type;
        this.signature = signature;
        this.consultation = consultation;
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

    public LocalDateTime getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(LocalDateTime prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public Modality getType() {
        return type;
    }

    public void setType(Modality type) {
        this.type = type;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
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
        Prescription that = (Prescription) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
