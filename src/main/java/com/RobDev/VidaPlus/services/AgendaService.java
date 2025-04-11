package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.agenda.AgendaRequest;
import com.RobDev.VidaPlus.dto.agenda.AgendaResponse;
import com.RobDev.VidaPlus.entities.Agenda;
import com.RobDev.VidaPlus.entities.HealthProfessional;
import com.RobDev.VidaPlus.exception.IdNotFoundException;
import com.RobDev.VidaPlus.mapper.AgendaMapper;
import com.RobDev.VidaPlus.repositories.AgendaRepository;
import com.RobDev.VidaPlus.repositories.HealthProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private HealthProfessionalRepository hpRepository;

    @Autowired
    private AgendaMapper agendaMapper;


    public AgendaResponse markingAgenda(long professionalId, AgendaRequest request){
        var professional = hpRepository.findById(professionalId)
                .orElseThrow(() -> new IdNotFoundException("Professional not found to create the task"));
        Agenda newAgenda = agendaMapper.toRequest(request);
        newAgenda.setProfessional(professional);

        return agendaMapper.toResponse(agendaRepository.save(newAgenda));
    }

    public AgendaResponse updatingAgenda(long agendaId, AgendaRequest request){
        var agenda = agendaRepository.findById(agendaId)
                .orElseThrow(() -> new IdNotFoundException("Task not found for update"));

        agendaMapper.requestUpdate(request,agenda);

        return agendaMapper.toResponse(agendaRepository.save(agenda));
    }
}
