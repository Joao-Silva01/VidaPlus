package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.healthProfessional.RecordProfessionalResponse;
import com.RobDev.VidaPlus.dto.medicalRecord.CreateMedicalRecordRequest;
import com.RobDev.VidaPlus.dto.medicalRecord.CreateMedicalRecordResponse;
import com.RobDev.VidaPlus.dto.medicalRecord.MedicalRecordResponse;
import com.RobDev.VidaPlus.services.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/record")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService recordService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicalRecordResponse> getRecord(@PathVariable long id){
        return ResponseEntity.ok().body(recordService.getRecord(id));
    }

    @PostMapping
    public ResponseEntity<CreateMedicalRecordResponse> create(@RequestBody CreateMedicalRecordRequest request){

        return ResponseEntity.ok().body(recordService.createRecord(request));
    }
}
