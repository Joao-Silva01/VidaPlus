package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.SucessResponse;
import com.RobDev.VidaPlus.dto.hospitalAdmission.CreateHospitalAdmissionRequest;
import com.RobDev.VidaPlus.dto.hospitalAdmission.HospitalAdmissionResponse;
import com.RobDev.VidaPlus.dto.hospitalAdmission.UpdateHospitalAdmissionRequest;
import com.RobDev.VidaPlus.services.HospitalAdmissionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hospitalization")
public class HospitalAdmissionController {

    @Autowired
    private HospitalAdmissionService hospitalAdmissionService;

    @PostMapping(value = "/{consultId}")
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<SucessResponse> createHospitalization(@PathVariable long consultId,
                                                                @Valid @RequestBody CreateHospitalAdmissionRequest request) {

        return ResponseEntity.ok().body(hospitalAdmissionService.hospitalizationCreate(consultId, request));

    }

    @PutMapping(value = "/{consultId}")
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<SucessResponse> updateHospitalization(@PathVariable long consultId,
                                                                           @Valid @RequestBody UpdateHospitalAdmissionRequest request) {

        return ResponseEntity.ok().body(hospitalAdmissionService.hospitalizationUpdate(consultId, request));
    }
}
