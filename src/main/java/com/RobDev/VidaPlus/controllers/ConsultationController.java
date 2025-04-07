package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.consultation.ConsultResponse;
import com.RobDev.VidaPlus.dto.consultation.UpdateConsultRequest;
import com.RobDev.VidaPlus.dto.consultation.CreateConsultRequest;
import com.RobDev.VidaPlus.dto.prescription.UpdatePrescriptionRequest;
import com.RobDev.VidaPlus.services.ConsultationService;
import com.RobDev.VidaPlus.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping(value = "/{consult_id}")
    public ResponseEntity<ConsultResponse> getById(@PathVariable long consult_id) {
        return ResponseEntity.ok().body(consultationService.getConsult(consult_id));
    }

    @GetMapping(value = "patient/{id}")
    public ResponseEntity<?> patientAllConsults(@PathVariable long id) {
        return ResponseEntity.ok().body(consultationService.getAllMedicalAppointmentsPatient(id));
    }

    @PostMapping
    public ResponseEntity<ConsultResponse> create(@RequestBody CreateConsultRequest request) {
        return ResponseEntity.ok().body(consultationService.createConsult(request));
    }

    @PutMapping(value = "/{consultId}")
    public ResponseEntity<?> update(@PathVariable long consultId,
                                    @RequestBody UpdateConsultRequest request) {
        consultationService.updateConsult(consultId, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{consultId}/prescription")
    public ResponseEntity<?> updatePrescription(@PathVariable long consultId,
                                                @RequestBody UpdatePrescriptionRequest request) {
        prescriptionService.prescriptionUpdate(consultId, request);
        return ResponseEntity.ok().build();
    }
}
