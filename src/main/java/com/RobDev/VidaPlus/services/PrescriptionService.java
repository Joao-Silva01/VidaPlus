package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.SucessResponse;
import com.RobDev.VidaPlus.dto.prescription.PrescriptionRequest;
import com.RobDev.VidaPlus.dto.prescription.PrescriptionResponse;
import com.RobDev.VidaPlus.dto.prescription.UpdatePrescriptionRequest;
import com.RobDev.VidaPlus.entities.Consultation;
import com.RobDev.VidaPlus.entities.Prescription;
import com.RobDev.VidaPlus.exception.IdNotFoundException;
import com.RobDev.VidaPlus.exception.ThisAlreadyExistsException;
import com.RobDev.VidaPlus.mapper.PrescriptionMapper;
import com.RobDev.VidaPlus.repositories.ConsultationRepository;
import com.RobDev.VidaPlus.repositories.PrescriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private PrescriptionMapper prescriptionMapper;

    public SucessResponse prescriptionCreate(long consultId, PrescriptionRequest request) {
        Consultation consultation = consultationRepository.findById(consultId)
                .orElseThrow(() -> new IdNotFoundException("Query not found for prescription creation"));
        if (consultation.getPrescription() != null) {
            throw new ThisAlreadyExistsException("This consultation already has a prescription");
        }
        Prescription prescription = prescriptionMapper.toCreatePrescription(request);
        prescription.setType(consultation.getType());
        prescription.setConsultation(consultation);
        consultation.setPrescription(prescription);
        prescription.setSignature(consultation.getProfessional().getSignature());

        prescriptionRepository.save(prescription);
        return new SucessResponse("Prescription created successfully");
    }

    public SucessResponse prescriptionUpdate(long consult_id, UpdatePrescriptionRequest request) {
        Consultation consultation = consultationRepository.findById(consult_id)
                .orElseThrow(() -> new IdNotFoundException("Query not found for prescription update!"));
        Prescription prescription = consultation.getPrescription();
        prescriptionMapper.requestUpdate(request, prescription);

        prescriptionRepository.save(prescription);
        return new SucessResponse("Prescription updated successfully");
    }
}
