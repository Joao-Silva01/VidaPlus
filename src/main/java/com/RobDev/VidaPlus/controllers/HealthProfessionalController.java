package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.healthprofessional.CreateHpRequest;
import com.RobDev.VidaPlus.dto.healthprofessional.HpResponse;
import com.RobDev.VidaPlus.services.HealthProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/professional")
public class HealthProfessionalController {

    @Autowired
    private HealthProfessionalService hpService;

    @PostMapping
    public ResponseEntity<HpResponse> create(@RequestBody CreateHpRequest request){
        return ResponseEntity.ok().body(hpService.createProfessional(request));
    }
}
