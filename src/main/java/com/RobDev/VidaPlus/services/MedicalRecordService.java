package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.healthProfessional.RecordProfessionalResponse;
import com.RobDev.VidaPlus.dto.medicalRecord.CreateMedicalRecordRequest;
import com.RobDev.VidaPlus.dto.medicalRecord.CreateMedicalRecordResponse;
import com.RobDev.VidaPlus.dto.medicalRecord.MedicalRecordResponse;
import com.RobDev.VidaPlus.entities.HealthProfessional;
import com.RobDev.VidaPlus.entities.MedicalRecord;
import com.RobDev.VidaPlus.entities.Patient;
import com.RobDev.VidaPlus.entities.UpdateLog;
import com.RobDev.VidaPlus.mapper.healthProfessional.HealthProfessionalMapper;
import com.RobDev.VidaPlus.mapper.medicalRecord.MedicalRecordMapper;
import com.RobDev.VidaPlus.repositories.HealthProfessionalRepository;
import com.RobDev.VidaPlus.repositories.MedicalRecordRepository;
import com.RobDev.VidaPlus.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
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
        patientRepository.findById(patientId).orElseThrow();
        MedicalRecord record = medicalRecordRepository.findByPatient(patientId);

        MedicalRecordResponse response = recordMapper.toResponse(record);

        // Tranformando os dados completos em mínimos e associando a resposta
        List<RecordProfessionalResponse> listProfessionals = record.getProfessionals().stream().map(x -> hpMapper.toMinResponse(x.getProfessional())).toList();
        response.setProfessionals(listProfessionals);

        return response;
    }

    public CreateMedicalRecordResponse createRecord(CreateMedicalRecordRequest request){
        HealthProfessional professional = professionalRepository.findById(request.getProfessionalId()).orElseThrow();
        Patient patient = patientRepository.findById(request.getPatientId()).orElseThrow();

        MedicalRecord medicalRecord = recordMapper.toCreateEntity(request);

        // Instanciando o log de criação
        UpdateLog updateLog = new UpdateLog();
        updateLog.setProfessional(professional);
        updateLog.setMedicalRecord(medicalRecord);
        updateLog.setUpdateDate(Timestamp.from(Instant.now()));
        updateLog.setUpdateDescription("Create Record");

        //Realizando os relacionamentos do Registro
        medicalRecord.setProfessionals(updateLog);
        medicalRecord.setPatient(patient);

        return recordMapper.toCreateResponse(medicalRecordRepository.save(medicalRecord));

    }
}
