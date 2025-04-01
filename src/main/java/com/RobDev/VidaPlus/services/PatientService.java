package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.Entities.Enums.UserRole;
import com.RobDev.VidaPlus.Repositories.PatientRepository;
import com.RobDev.VidaPlus.dto.CreatePatientRequest;
import com.RobDev.VidaPlus.dto.PatientResponse;
import com.RobDev.VidaPlus.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    public PatientResponse byId(long id){
        return patientMapper.toResponseDTO(patientRepository.findById(id).orElseThrow());
    }
    public List<PatientResponse> allPatients(){
        return patientMapper.toList(patientRepository.findAll());
    }

    public PatientResponse createPatient(CreatePatientRequest request){
        var newPatient = patientMapper.toEntity(request);
        newPatient.setRole(UserRole.PATIENT);
        return patientMapper.toResponseDTO(patientRepository.save(newPatient));
    }
}
