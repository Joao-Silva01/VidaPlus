package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.Entities.Enums.UserRole;
import com.RobDev.VidaPlus.Repositories.PatientRepository;
import com.RobDev.VidaPlus.dto.CreatePatientRequest;
import com.RobDev.VidaPlus.dto.PatientResponse;
import com.RobDev.VidaPlus.dto.UpdatePatientRequest;
import com.RobDev.VidaPlus.mapper.PatientMapper;
import com.RobDev.VidaPlus.mapper.PatientUpdate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private PatientUpdate patientUpdate;



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
        patientUpdate.update(request,patient);
        patientRepository.save(patient);
    }
}
