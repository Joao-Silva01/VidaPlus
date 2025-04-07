package com.RobDev.VidaPlus.mapper.healthProfessional;

import com.RobDev.VidaPlus.entities.HealthProfessional;
import com.RobDev.VidaPlus.dto.healthProfessional.UpdateHpRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HealthProfessionalUpdate {

    void requestUpdate(UpdateHpRequest request, @MappingTarget HealthProfessional entity);
}
