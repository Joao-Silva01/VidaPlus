package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.consultation.ConsultResponse;
import com.RobDev.VidaPlus.dto.consultation.UpdateConsultRequest;
import com.RobDev.VidaPlus.dto.consultation.CreateConsultRequest;
import com.RobDev.VidaPlus.dto.consultation.UpdateConsultResponse;
import com.RobDev.VidaPlus.services.ConsultationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @GetMapping(value = "/{consult_id}")
    public ResponseEntity<ConsultResponse> getById(@PathVariable long consult_id) {
        return ResponseEntity.ok().body(consultationService.getConsult(consult_id));
    }

    @PostMapping
    public ResponseEntity<ConsultResponse> create( @Valid @RequestBody CreateConsultRequest request) {
        return ResponseEntity.ok().body(consultationService.createConsult(request));
    }

    @PutMapping(value = "/{consultId}")
    public ResponseEntity<UpdateConsultResponse> update(@PathVariable long consultId,
                                                        @Valid @RequestBody UpdateConsultRequest request) {

        return ResponseEntity.ok().body(consultationService.updateConsult(consultId, request));
    }
}
