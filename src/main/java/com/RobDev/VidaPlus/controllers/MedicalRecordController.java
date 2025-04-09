package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.medicalRecord.CreateMedicalRecordRequest;
import com.RobDev.VidaPlus.dto.medicalRecord.MinMedicalRecordResponse;
import com.RobDev.VidaPlus.dto.medicalRecord.MedicalRecordResponse;
import com.RobDev.VidaPlus.dto.medicalRecord.UpdateMedicalRecordRequest;
import com.RobDev.VidaPlus.services.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/record")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService recordService;

    @GetMapping(value = "/{patientId}")
    public ResponseEntity<MedicalRecordResponse> getRecord(@PathVariable long patientId){
        return ResponseEntity.ok().body(recordService.getRecord(patientId));
    }

    @PostMapping
    public ResponseEntity<MinMedicalRecordResponse> create(@RequestBody CreateMedicalRecordRequest request){

        return ResponseEntity.ok().body(recordService.createRecord(request));
    }

    @PutMapping(value = "/{patientId}")
    public ResponseEntity<MinMedicalRecordResponse> update(@PathVariable long patientId,@RequestBody UpdateMedicalRecordRequest request){
        return ResponseEntity.ok().body(recordService.updateRecord(patientId,request));
    }
}
