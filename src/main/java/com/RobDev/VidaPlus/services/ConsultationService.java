package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.Entities.*;
import com.RobDev.VidaPlus.Repositories.ConsultationRepository;
import com.RobDev.VidaPlus.Repositories.HealthProfessionalRepository;
import com.RobDev.VidaPlus.Repositories.PatientRepository;
import com.RobDev.VidaPlus.Repositories.PrescriptionRepository;
import com.RobDev.VidaPlus.dto.consultation.ConsultResponse;
import com.RobDev.VidaPlus.dto.consultation.CreateConsultRequest;
import com.RobDev.VidaPlus.mapper.ConsultationMapper;
import com.RobDev.VidaPlus.mapper.HospitalAdmissionMapper;
import com.RobDev.VidaPlus.mapper.MedicalExaminationMapper;
import com.RobDev.VidaPlus.mapper.PrescriptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private HealthProfessionalRepository hpRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ConsultationMapper consultMapper;

    @Autowired
    private PrescriptionMapper prescriptionMapper;

    @Autowired
    private MedicalExaminationMapper examMapper;

    @Autowired
    private HospitalAdmissionMapper admissionMapper;

    public ConsultResponse createConsult(long professional_id, CreateConsultRequest request) {
        HealthProfessional professional = hpRepository.findById(professional_id).orElseThrow();
        Patient patient = patientRepository.findById(request.getPatient_id()).orElseThrow();

        Consultation newConsult = consultMapper.toCreateConsult(request);
        newConsult.setPatient(patient);
        newConsult.setProfessional(professional);

        return consultMapper.toResponse(consultationRepository.save(newConsult));

    }
}
