package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.agenda.AgendaRequest;
import com.RobDev.VidaPlus.dto.agenda.AgendaResponse;
import com.RobDev.VidaPlus.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping(value = "/{professionalId}")
    public ResponseEntity<AgendaResponse> create(@PathVariable long professionalId, @RequestBody AgendaRequest request){
        return ResponseEntity.ok().body(agendaService.markingAgenda(professionalId, request));
    }

    @PutMapping(value = "/{agendaId}")
    public ResponseEntity<AgendaResponse> update(@PathVariable long agendaId, @RequestBody AgendaRequest request){
        return ResponseEntity.ok().body(agendaService.updatingAgenda(agendaId,request));
    }
}
