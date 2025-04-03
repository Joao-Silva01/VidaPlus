package com.RobDev.VidaPlus.mapper;

import com.RobDev.VidaPlus.Entities.HealthProfessional;
import com.RobDev.VidaPlus.dto.healthprofessional.UpdateHpRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HealthProfessionalUpdate {

    void update(UpdateHpRequest request, @MappingTarget HealthProfessional entity);
}
