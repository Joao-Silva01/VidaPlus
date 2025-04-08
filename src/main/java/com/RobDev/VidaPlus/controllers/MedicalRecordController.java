package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.medicalRecord.CreateMedicalRecordRequest;
import com.RobDev.VidaPlus.dto.medicalRecord.MedicalRecordResponse;
import com.RobDev.VidaPlus.services.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/record")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService recordService;

    @PostMapping
    public ResponseEntity<MedicalRecordResponse> create(@RequestBody CreateMedicalRecordRequest request){

        return ResponseEntity.ok().body(recordService.createRecord(request));
    }
}
