package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.healthprofessional.CreateHpRequest;
import com.RobDev.VidaPlus.dto.healthprofessional.HpResponse;
import com.RobDev.VidaPlus.services.HealthProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/professional")
public class HealthProfessionalController {

    @Autowired
    private HealthProfessionalService hpService;

    @GetMapping
    public ResponseEntity<List<HpResponse>> listAll (){
        return ResponseEntity.ok().body(hpService.allProfessionals());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<HpResponse> findById(@PathVariable long id){
        return ResponseEntity.ok().body(hpService.byId(id));
    }

    @PostMapping
    public ResponseEntity<HpResponse> create(@RequestBody CreateHpRequest request){
        return ResponseEntity.ok().body(hpService.createProfessional(request));
    }
}
