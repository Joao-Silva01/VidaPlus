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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class HospitalAdmissionService {

    @Autowired
    private HospitalAdmissionRepository hospitalAdmissionRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private HospitalAdmissionMapper admissionMapper;

    public HospitalAdmissionResponse hospitalizationCreate(long consultId, CreateHospitalAdmissionRequest request) {
        Consultation consultation = consultationRepository.findById(consultId)
                .orElseThrow(() -> new HospitalizationBadRequestException("Query not found for creating hospitalization"));

        if (consultation.getHospitalization() != null) {
            throw new HospitalizationBadRequestException("This consultation already has a hospitalization");
        }

        HospitalAdmission admission = admissionMapper.toCreateEntity(request);
        admission.setConsultation(consultation);
        consultation.setHospitalization(admission);

        HospitalAdmissionResponse response = admissionMapper.toResponse(admission);

        if (admission.getDischargeDate() == null) {
            return admissionMapper.toResponse(hospitalAdmissionRepository.save(admission));
        } else {
            var totalCost = totalValueHospitalization(admission.getDailyCost(),
                    admission.getHospitalizationDate(),
                    admission.getDischargeDate());

            admission.setTotalCost(totalCost);
        }


        return admissionMapper.toResponse(hospitalAdmissionRepository.save(admission));
    }

    public HospitalAdmissionResponse hospitalizationUpdate(long consultId, UpdateHospitalAdmissionRequest request) {
        Consultation consultation = consultationRepository.findById(consultId)
                .orElseThrow(() -> new IdNotFoundException("Query not found for hospitalization update!"));

        HospitalAdmission hospitalization = consultation.getHospitalization();

        admissionMapper.requestUpdate(request, hospitalization);

        if (hospitalization.getDischargeDate() == null) {
            return admissionMapper.toResponse(hospitalAdmissionRepository.save(hospitalization));
        } else {
            var totalCost = totalValueHospitalization(
                    hospitalization.getDailyCost(),
                    hospitalization.getHospitalizationDate(),
                    hospitalization.getDischargeDate());

            hospitalization.setTotalCost(totalCost);
        }

        return admissionMapper.toResponse(hospitalAdmissionRepository.save(hospitalization));
    }


    public static BigDecimal totalValueHospitalization(BigDecimal dailyCost, LocalDateTime startDate, LocalDateTime endDate) {

        Long totalDays = null;

        // adiciona mais 1 dia caso a data da alta do paciente passe de 12 horas
        if (endDate.getHour() > 12) {
            totalDays = ChronoUnit.DAYS.between(startDate, endDate.plusDays(1));
        } else {
            totalDays = ChronoUnit.DAYS.between(startDate, endDate);
        }

        //Realiza o calculo total do custo da hospitalização
        BigDecimal calculation = dailyCost.multiply(BigDecimal.valueOf(totalDays));

        return calculation;

    }
}
