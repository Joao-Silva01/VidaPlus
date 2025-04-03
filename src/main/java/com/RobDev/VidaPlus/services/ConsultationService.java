package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.Entities.Patient;
import com.RobDev.VidaPlus.Repositories.ConsultationRepository;
import com.RobDev.VidaPlus.Repositories.HealthProfessionalRepository;
import com.RobDev.VidaPlus.Repositories.PatientRepository;
import com.RobDev.VidaPlus.dto.consultation.ConsultResponse;
import com.RobDev.VidaPlus.dto.consultation.CreateConsultRequest;
import com.RobDev.VidaPlus.mapper.ConsultationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void createConsult(long professional_id,CreateConsultRequest request){
        var professional = hpRepository.findById(professional_id).orElseThrow();
        var patient = patientRepository.findById(request.getPatient_id()).orElseThrow();

        var newConsult = consultMapper.toCreateConsult(request);
        newConsult.setPatient(patient);
        newConsult.setProfessional(professional);
        var k =0;

    }
}
