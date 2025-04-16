package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.medicalRecord.CreateMedicalRecordRequest;
import com.RobDev.VidaPlus.dto.medicalRecord.MinMedicalRecordResponse;
import com.RobDev.VidaPlus.dto.medicalRecord.MedicalRecordResponse;
import com.RobDev.VidaPlus.dto.updateLog.UpdateLogRequest;
import com.RobDev.VidaPlus.services.MedicalRecordService;
import com.RobDev.VidaPlus.services.UpdateLogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/record")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService recordService;

    @Autowired
    private UpdateLogService updateLogService;

    @GetMapping(value = "/{patientId}")
    public ResponseEntity<MedicalRecordResponse> getRecord(@PathVariable long patientId){
        return ResponseEntity.ok().body(recordService.getRecord(patientId));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<MinMedicalRecordResponse> create(@Valid @RequestBody CreateMedicalRecordRequest request){

        return ResponseEntity.ok().body(recordService.createRecord(request));
    }

    @PutMapping(value = "/{patientId}")
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<Void> updateLog(@PathVariable long patientId,@RequestBody UpdateLogRequest request){

        updateLogService.createLog(patientId,request);
        return ResponseEntity.ok().build();
    }
}
