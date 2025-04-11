package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.hospitalAdmission.CreateHospitalAdmissionRequest;
import com.RobDev.VidaPlus.dto.hospitalAdmission.HospitalAdmissionResponse;
import com.RobDev.VidaPlus.dto.hospitalAdmission.UpdateHospitalAdmissionRequest;
import com.RobDev.VidaPlus.entities.Consultation;
import com.RobDev.VidaPlus.entities.HospitalAdmission;
import com.RobDev.VidaPlus.exception.HospitalizationBadRequestException;
import com.RobDev.VidaPlus.exception.IdNotFoundException;
import com.RobDev.VidaPlus.mapper.HospitalAdmissionMapper;
import com.RobDev.VidaPlus.repositories.ConsultationRepository;
import com.RobDev.VidaPlus.repositories.HospitalAdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalAdmissionService {

    @Autowired
    private HospitalAdmissionRepository  hospitalAdmissionRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private HospitalAdmissionMapper admissionMapper;

    public HospitalAdmissionResponse hospitalizationCreate(long consultId, CreateHospitalAdmissionRequest request){
        Consultation consultation = consultationRepository.findById(consultId)
                .orElseThrow(() -> new HospitalizationBadRequestException("Query not found for creating hospitalization"));

        if (consultation.getHospitalization() != null){
            throw new HospitalizationBadRequestException("This consultation already has a hospitalization");
        }

        HospitalAdmission admission = admissionMapper.toCreateEntity(request);
        admission.setConsultation(consultation);
        consultation.setHospitalization(admission);

        HospitalAdmissionResponse response = admissionMapper.toResponse(hospitalAdmissionRepository.save(admission));
        response.setTotalCost(admission.totalValueHospitalization());

        return response;
    }

    public HospitalAdmissionResponse hospitalizationUpdate(long consultId, UpdateHospitalAdmissionRequest request){
        Consultation consultation = consultationRepository.findById(consultId)
                .orElseThrow(() -> new IdNotFoundException("Query not found for hospitalization update!"));

        HospitalAdmission hospitalization = consultation.getHospitalization();

        admissionMapper.requestUpdate(request,hospitalization);

        HospitalAdmissionResponse response = admissionMapper.toResponse(hospitalAdmissionRepository.save(hospitalization));
        response.setTotalCost(hospitalization.totalValueHospitalization());

        return response;
    }
}
