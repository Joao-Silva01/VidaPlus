package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.healthProfessional.CreateHpRequest;
import com.RobDev.VidaPlus.dto.healthProfessional.HpResponse;
import com.RobDev.VidaPlus.dto.healthProfessional.UpdateHpRequest;
import com.RobDev.VidaPlus.services.HealthProfessionalService;
import jakarta.validation.Valid;
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
    public ResponseEntity<HpResponse> create(@Valid @RequestBody CreateHpRequest request){
        return ResponseEntity.ok().body(hpService.createProfessional(request));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable long id,@Valid @RequestBody UpdateHpRequest request){
        hpService.updateProfessional(id,request);
        return ResponseEntity.ok().build();
    }
}
