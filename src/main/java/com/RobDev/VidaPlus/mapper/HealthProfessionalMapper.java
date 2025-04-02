package com.RobDev.VidaPlus.mapper;

import com.RobDev.VidaPlus.Entities.HealthProfessional;
import com.RobDev.VidaPlus.dto.healthprofessional.CreateHpRequest;
import com.RobDev.VidaPlus.dto.healthprofessional.HpResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HealthProfessionalMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    HealthProfessional toCreateEntity(CreateHpRequest request);

    HpResponse toResponse(HealthProfessional entity);

    List<HpResponse> toList(List<HealthProfessional> entityList);
}
