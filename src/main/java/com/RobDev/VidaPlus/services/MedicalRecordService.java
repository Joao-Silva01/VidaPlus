package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.healthProfessional.MinHpResponse;
import com.RobDev.VidaPlus.dto.medicalRecord.CreateMedicalRecordRequest;
import com.RobDev.VidaPlus.dto.medicalRecord.MinMedicalRecordResponse;
import com.RobDev.VidaPlus.dto.medicalRecord.MedicalRecordResponse;
import com.RobDev.VidaPlus.entities.HealthProfessional;
import com.RobDev.VidaPlus.entities.MedicalRecord;
import com.RobDev.VidaPlus.entities.Patient;
import com.RobDev.VidaPlus.entities.UpdateLog;
import com.RobDev.VidaPlus.exception.IdNotFoundException;
import com.RobDev.VidaPlus.exception.ThisAlreadyExistsException;
import com.RobDev.VidaPlus.mapper.HealthProfessionalMapper;
import com.RobDev.VidaPlus.mapper.MedicalRecordMapper;
import com.RobDev.VidaPlus.repositories.HealthProfessionalRepository;
import com.RobDev.VidaPlus.repositories.MedicalRecordRepository;
import com.RobDev.VidaPlus.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private HealthProfessionalRepository professionalRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicalRecordMapper recordMapper;

    @Autowired
    private HealthProfessionalMapper hpMapper;

    public MedicalRecordResponse getRecord(long patientId){
        MedicalRecord record = medicalRecordRepository.findByPatient(patientId)
                .orElseThrow(() -> new IdNotFoundException("Medical Record not found!"));

        MedicalRecordResponse response = recordMapper.toResponse(record);

        // Diminuindo os dados dos profissionais para a resposta
        List<MinHpResponse> listProfessionals = record.getProfessionals().stream().map(x -> hpMapper.toMinResponse(x.getProfessional())).toList();
        response.setProfessionals(listProfessionals);

        return response;
    }

    public MinMedicalRecordResponse createRecord(CreateMedicalRecordRequest request){

        if (medicalRecordRepository.findByPatient(request.getPatientId()).isPresent()){
            throw new ThisAlreadyExistsException("This patient already has a medical record, " +
                    "now he only has the option to update it");
        }

        HealthProfessional professional = professionalRepository.findById(request.getProfessionalId())
                .orElseThrow(() -> new IdNotFoundException("Healthcare professional not found to create medical record!"));

        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new IdNotFoundException("Patient not found for Medical Record creation!"));

        MedicalRecord medicalRecord = recordMapper.toCreateEntity(request);
        medicalRecord.setDateRecord(Timestamp.from(Instant.now()));

        // Instanciando o log de criação
        UpdateLog updateLog = new UpdateLog();
        updateLog.setProfessional(professional);
        updateLog.setMedicalRecord(medicalRecord);
        updateLog.setUpdateDate(LocalDateTime.now());
        updateLog.setUpdateDescription("Create Record");

        //Realizando os relacionamentos do Registro
        medicalRecord.setProfessionals(updateLog);
        medicalRecord.setPatient(patient);

        return recordMapper.toMinResponse(medicalRecordRepository.save(medicalRecord));
    }
}
