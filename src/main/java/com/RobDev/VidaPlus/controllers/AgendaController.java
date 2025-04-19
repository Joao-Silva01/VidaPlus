package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.SucessResponse;
import com.RobDev.VidaPlus.dto.agenda.AgendaRequest;
import com.RobDev.VidaPlus.dto.agenda.AgendaResponse;
import com.RobDev.VidaPlus.services.AgendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping(value = "/{professionalId}")
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<SucessResponse> create(@PathVariable long professionalId, @Valid @RequestBody AgendaRequest request){
        return ResponseEntity.ok().body(agendaService.markingAgenda(professionalId, request));
    }

    @PutMapping(value = "/{agendaId}")
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<SucessResponse> update(@PathVariable long agendaId,@Valid @RequestBody AgendaRequest request){
        return ResponseEntity.ok().body(agendaService.updatingAgenda(agendaId,request));
    }
}
