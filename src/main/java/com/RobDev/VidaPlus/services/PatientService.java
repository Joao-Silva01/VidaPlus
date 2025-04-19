package com.RobDev.VidaPlus.services;


import com.RobDev.VidaPlus.dto.SucessResponse;
import com.RobDev.VidaPlus.dto.patient.*;
import com.RobDev.VidaPlus.entities.Patient;
import com.RobDev.VidaPlus.entities.enums.UserRole;
import com.RobDev.VidaPlus.exception.IdNotFoundException;
import com.RobDev.VidaPlus.exception.ThisAlreadyExistsException;
import com.RobDev.VidaPlus.repositories.HospitalAdmissionRepository;
import com.RobDev.VidaPlus.repositories.PatientRepository;
import com.RobDev.VidaPlus.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private HospitalAdmissionRepository admissionRepository;

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public PatientResponse byId(long id) {
        return patientMapper.toResponseDTO(patientRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Patient not found!")));
    }

    public List<PatientResponse> allPatients() {
        return patientMapper.toList(patientRepository.findAll());
    }

    public SucessResponse createPatient(CreatePatientRequest request) {

        if(patientRepository.findByEmail(request.getEmail()).isPresent() || patientRepository.findByDocument(request.getDocument()).isPresent()){
            throw new ThisAlreadyExistsException("The email or document is already registered.");
        }

        Patient newPatient = patientMapper.toCreateEntity(request);
        newPatient.setRole(UserRole.PATIENT);
        newPatient.setRegisterMoment(LocalDateTime.now());
        newPatient.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));

        return new SucessResponse("Patient created successfully");
    }

    public SucessResponse updatePatient(long id, UpdatePatientRequest request) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Patient not found for update!"));
        patientMapper.requestUpdate(request, patient);
        patientRepository.save(patient);

        return new SucessResponse("Patient successfully updated");
    }

    public AllConsultationsPatientResponse getAllMedicalAppointmentsPatient(long patient_id) {
        var patient = patientRepository.findById(patient_id)
                .orElseThrow(() -> new IdNotFoundException("Patient not found!"));

        return patientMapper.toAllConsultationsResponse(patient);
    }

    public PatientNotificationResponse allNotification(long id){
        var patient = patientRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Patient not found"));

        return patientMapper.toPatientNotification(patient);
    }
}
