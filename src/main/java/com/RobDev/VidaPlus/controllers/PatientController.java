package com.RobDev.VidaPlus.controllers;


import com.RobDev.VidaPlus.dto.patiente.CreatePatientRequest;
import com.RobDev.VidaPlus.dto.patiente.PatientResponse;
import com.RobDev.VidaPlus.dto.patiente.UpdatePatientRequest;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<PatientResponse> findById(@PathVariable long id){
        return ResponseEntity.ok().body(patientService.byId(id));
    }

    @PostMapping
    public ResponseEntity<PatientResponse> create(@RequestBody CreatePatientRequest request){
        return  ResponseEntity.ok().body(patientService.createPatient(request));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody UpdatePatientRequest request){
        patientService.updatePatient(id,request);
        return ResponseEntity.ok().build();
    }
}
