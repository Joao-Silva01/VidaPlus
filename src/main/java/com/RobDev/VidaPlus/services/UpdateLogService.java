package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.updateLog.UpdateLogRequest;
import com.RobDev.VidaPlus.dto.updateLog.UpdateLogResponse;
import com.RobDev.VidaPlus.entities.HealthProfessional;
import com.RobDev.VidaPlus.entities.MedicalRecord;
import com.RobDev.VidaPlus.entities.UpdateLog;
import com.RobDev.VidaPlus.exception.IdNotFoundException;
import com.RobDev.VidaPlus.mapper.UpdateLogMapper;
import com.RobDev.VidaPlus.repositories.HealthProfessionalRepository;
import com.RobDev.VidaPlus.repositories.MedicalRecordRepository;
import com.RobDev.VidaPlus.repositories.UpdateLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateLogService {

    @Autowired
    private UpdateLogRepository updateLogRepository;

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private HealthProfessionalRepository hpRepository;

    @Autowired
    private UpdateLogMapper updateLogMapper;

    public List<UpdateLogResponse> getAllLogs (){

        return updateLogMapper.toListResponse(updateLogRepository.findAll());
    }

    //  Esse serviço serve tanto para criar e atualizar o MedicalRecord
    public void createLog(long patientId,UpdateLogRequest request){

        MedicalRecord record = medicalRecordRepository.findByPatient(patientId)
                .orElseThrow(() -> new IdNotFoundException("Medical record not found for update!"));

        HealthProfessional professional = hpRepository.findById(request.getProfessionalId())
                .orElseThrow(() -> new IdNotFoundException("Professional not found for update!"));

        updateLogMapper.logUpdateRequest(request, record);

        UpdateLog log = updateLogMapper.toRequest(request);
        log.setMedicalRecord(record);
        log.setProfessional(professional);

        updateLogRepository.save(log);
    }
}
