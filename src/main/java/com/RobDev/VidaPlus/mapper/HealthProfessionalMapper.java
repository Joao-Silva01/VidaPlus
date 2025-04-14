package com.RobDev.VidaPlus.mapper;

import com.RobDev.VidaPlus.dto.healthProfessional.*;
import com.RobDev.VidaPlus.entities.HealthProfessional;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HealthProfessionalMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    HealthProfessional toCreateEntity(CreateHpRequest request);

    HpResponse toResponse(HealthProfessional entity);

    RecordProfessionalResponse toMinResponse(HealthProfessional entity);

    List<HpResponse> toList(List<HealthProfessional> entityList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void requestUpdate(UpdateHpRequest request, @MappingTarget HealthProfessional entity);


    HpAgendaResponse toAllCommitmentsResponse(HealthProfessional entity);
}
