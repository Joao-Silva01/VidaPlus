package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.SucessResponse;
import com.RobDev.VidaPlus.dto.prescription.PrescriptionRequest;
import com.RobDev.VidaPlus.dto.prescription.PrescriptionResponse;
import com.RobDev.VidaPlus.dto.prescription.UpdatePrescriptionRequest;
import com.RobDev.VidaPlus.services.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping(value = "/{consultId}")
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<SucessResponse> createPrescription(@PathVariable long consultId, @Valid @RequestBody PrescriptionRequest request){
        return ResponseEntity.ok().body(prescriptionService.prescriptionCreate(consultId,request));
    }

    @PutMapping(value = "/{consultId}/prescription")
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<SucessResponse> updatePrescription(@PathVariable long consultId,
                                                                   @Valid @RequestBody UpdatePrescriptionRequest request) {
        return ResponseEntity.ok().body(prescriptionService.prescriptionUpdate(consultId, request));
    }
}
