package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.prescription.PrescriptionRequest;
import com.RobDev.VidaPlus.dto.prescription.PrescriptionResponse;
import com.RobDev.VidaPlus.dto.prescription.UpdatePrescriptionRequest;
import com.RobDev.VidaPlus.services.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping(value = "/{consultId}")
    public ResponseEntity<PrescriptionResponse> createPrescription(@PathVariable long consultId,@Valid @RequestBody PrescriptionRequest request){
        return ResponseEntity.ok().body(prescriptionService.prescriptionCreate(consultId,request));
    }

    @PutMapping(value = "/{consultId}/prescription")
    public ResponseEntity<PrescriptionResponse> updatePrescription(@PathVariable long consultId,
                                                                   @Valid @RequestBody UpdatePrescriptionRequest request) {
        return ResponseEntity.ok().body(prescriptionService.prescriptionUpdate(consultId, request));
    }
}
