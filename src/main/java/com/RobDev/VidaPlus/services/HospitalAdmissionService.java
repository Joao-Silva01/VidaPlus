package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.hospitalAdmission.UpdateHospitalAdmissionRequest;
import com.RobDev.VidaPlus.entities.Consultation;
import com.RobDev.VidaPlus.entities.HospitalAdmission;
import com.RobDev.VidaPlus.mapper.hospitalAdmission.HospitalAdmissionMapper;
import com.RobDev.VidaPlus.mapper.hospitalAdmission.HospitalAdmissionUpdate;
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
    private HospitalAdmissionUpdate admissionUpdate;

    public void HospitalizationUpdate(long consultId, UpdateHospitalAdmissionRequest request){
        Consultation consultation = consultationRepository.findById(consultId).orElseThrow();
        HospitalAdmission hospitalization = consultation.getHospitalization();

        admissionUpdate.requestUpdate(request,hospitalization);

        hospitalAdmissionRepository.save(hospitalization);
    }
}
