package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.SucessResponse;
import com.RobDev.VidaPlus.dto.healthProfessional.CreateHpRequest;
import com.RobDev.VidaPlus.dto.healthProfessional.HpAgendaResponse;
import com.RobDev.VidaPlus.dto.healthProfessional.HpResponse;
import com.RobDev.VidaPlus.dto.healthProfessional.UpdateHpRequest;
import com.RobDev.VidaPlus.services.HealthProfessionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/professional")
public class HealthProfessionalController {

    @Autowired
    private HealthProfessionalService hpService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<List<HpResponse>> listAll (){
        return ResponseEntity.ok().body(hpService.allProfessionals());
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<HpResponse> findById(@PathVariable long id){
        return ResponseEntity.ok().body(hpService.byId(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<SucessResponse> create(@Valid @RequestBody CreateHpRequest request){
        return ResponseEntity.ok().body(hpService.createProfessional(request));
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<Void> update(@PathVariable long id,@Valid @RequestBody UpdateHpRequest request){
        hpService.updateProfessional(id,request);
        return ResponseEntity.ok().build();
    }


    @GetMapping(value = "agenda/{id}")
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<HpAgendaResponse> allCommitments(@PathVariable long id){

        return ResponseEntity.ok().body(hpService.allCommitments(id));
    }
}
