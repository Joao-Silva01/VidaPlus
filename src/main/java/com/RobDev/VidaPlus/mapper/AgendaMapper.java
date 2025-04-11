package com.RobDev.VidaPlus.mapper;

import com.RobDev.VidaPlus.dto.agenda.AgendaRequest;
import com.RobDev.VidaPlus.dto.agenda.AgendaResponse;
import com.RobDev.VidaPlus.entities.Agenda;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AgendaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "professional", ignore = true)
    Agenda toRequest(AgendaRequest request);

    AgendaResponse toResponse(Agenda entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void requestUpdate(AgendaRequest request,@MappingTarget Agenda entity);
}
