package com.RobDev.VidaPlus.controllers;


import com.RobDev.VidaPlus.dto.SucessResponse;
import com.RobDev.VidaPlus.dto.patient.*;
import com.RobDev.VidaPlus.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<List<PatientResponse>> listAll (){
        return ResponseEntity.ok().body(patientService.allPatients());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PatientResponse> findById(@PathVariable long id){
        return ResponseEntity.ok().body(patientService.byId(id));
    }

    @PostMapping
    public ResponseEntity<SucessResponse> create(@Valid @RequestBody CreatePatientRequest request){
        return  ResponseEntity.ok().body(patientService.createPatient(request));
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAnyAuthority('PATIENT','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<SucessResponse> update(@PathVariable long id, @Valid @RequestBody UpdatePatientRequest request){

        return ResponseEntity.ok().body(patientService.updatePatient(id,request));
    }

    @GetMapping(value = "/{id}/consults")
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<AllConsultationsPatientResponse> patientAllConsults(@PathVariable long id) {
        return ResponseEntity.ok().body(patientService.getAllMedicalAppointmentsPatient(id));
    }

    @GetMapping(value = "/{id}/notifications")
    public ResponseEntity<PatientNotificationResponse> allNotification(@PathVariable long id){
        return ResponseEntity.ok().body(patientService.allNotification(id));
    }
}
