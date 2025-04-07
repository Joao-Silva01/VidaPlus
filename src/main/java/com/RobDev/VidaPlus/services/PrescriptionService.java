package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.prescription.PrescriptionResponse;
import com.RobDev.VidaPlus.dto.prescription.UpdatePrescriptionRequest;
import com.RobDev.VidaPlus.entities.Consultation;
import com.RobDev.VidaPlus.entities.Prescription;
import com.RobDev.VidaPlus.mapper.prescription.PrescriptionMapper;
import com.RobDev.VidaPlus.mapper.prescription.PrescriptionUpdate;
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
    private PrescriptionUpdate prescriptionUpdate;

    @Autowired
    private PrescriptionMapper prescriptionMapper;

    public PrescriptionResponse prescriptionUpdate(long consult_id, UpdatePrescriptionRequest request){
        Consultation consultation = consultationRepository.findById(consult_id).orElseThrow();
        Prescription prescription = consultation.getPrescription();
        prescriptionUpdate.requestUpdate(request, prescription);

        return prescriptionMapper.toResponse(prescriptionRepository.save(prescription));
    }
}
