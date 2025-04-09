package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.entities.enums.UserRole;
import com.RobDev.VidaPlus.repositories.PatientRepository;
import com.RobDev.VidaPlus.dto.patiente.CreatePatientRequest;
import com.RobDev.VidaPlus.dto.patiente.PatientResponse;
import com.RobDev.VidaPlus.dto.patiente.UpdatePatientRequest;
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
        var newPatient = patientMapper.toCreateEntity(request);
        newPatient.setRole(UserRole.PATIENT);
        return patientMapper.toResponseDTO(patientRepository.save(newPatient));
    }

    public void updatePatient(long id,UpdatePatientRequest request){
        var patient = patientRepository.findById(id).orElseThrow();
        patientMapper.requestUpdate(request,patient);
        patientRepository.save(patient);
    }
}
