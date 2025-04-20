package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.SucessResponse;
import com.RobDev.VidaPlus.dto.consultation.*;
import com.RobDev.VidaPlus.services.ConsultationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
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

    @GetMapping(value = "/{consultId}/link")
    public ResponseEntity<ConsultationLinkResponse> getLinkConsult(@PathVariable long consultId) {
        return ResponseEntity.ok().body(consultationService.linkConsult(consultId));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<SucessResponse> create(@Valid @RequestBody CreateConsultRequest request) {
        return ResponseEntity.ok().body(consultationService.createConsult(request));
    }

    @PutMapping(value = "/{consultId}")
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<SucessResponse> update(@PathVariable long consultId,
                                                        @Valid @RequestBody UpdateConsultRequest request) {

        return ResponseEntity.ok().body(consultationService.updateConsult(consultId, request));
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable long id){
        consultationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
