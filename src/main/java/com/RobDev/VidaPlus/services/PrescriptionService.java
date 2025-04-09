package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.prescription.PrescriptionRequest;
import com.RobDev.VidaPlus.dto.prescription.PrescriptionResponse;
import com.RobDev.VidaPlus.dto.prescription.UpdatePrescriptionRequest;
import com.RobDev.VidaPlus.entities.Consultation;
import com.RobDev.VidaPlus.entities.Prescription;
import com.RobDev.VidaPlus.exception.IdNotFoundException;
import com.RobDev.VidaPlus.mapper.PrescriptionMapper;
import com.RobDev.VidaPlus.repositories.ConsultationRepository;
import com.RobDev.VidaPlus.repositories.PrescriptionRepository;
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

    public PrescriptionResponse prescriptionCreate(long consultId,PrescriptionRequest request){
        Consultation consultation = consultationRepository.findById(consultId).orElseThrow();
        if (consultation.getPrescription() != null){
            System.out.println("Tem prescrição");
            return null;
        }
        Prescription prescription = prescriptionMapper.toCreatePrescription(request);
        prescription.setConsultation(consultation);
        consultation.setPrescription(prescription);

        return prescriptionMapper.toResponse(prescriptionRepository.save(prescription));
    }

    public PrescriptionResponse prescriptionUpdate(long consult_id, UpdatePrescriptionRequest request){
        Consultation consultation = consultationRepository.findById(consult_id)
                .orElseThrow(() -> new IdNotFoundException("Query not found for prescription update!"));
        Prescription prescription = consultation.getPrescription();
        prescriptionMapper.requestUpdate(request, prescription);

        return prescriptionMapper.toResponse(prescriptionRepository.save(prescription));
    }
}
