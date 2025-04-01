package com.RobDev.VidaPlus.controllers;


import com.RobDev.VidaPlus.dto.CreatePatientRequest;
import com.RobDev.VidaPlus.dto.PatientResponse;
import com.RobDev.VidaPlus.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponse>> listAll (){
        return ResponseEntity.ok().body(patientService.allPatients());
    }
    @PostMapping
    public ResponseEntity<PatientResponse> create(@RequestBody CreatePatientRequest request){
        return  ResponseEntity.ok().body(patientService.createPatient(request));
    }
}
