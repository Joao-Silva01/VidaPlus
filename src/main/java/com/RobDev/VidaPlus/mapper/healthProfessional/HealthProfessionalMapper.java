package com.RobDev.VidaPlus.mapper.healthProfessional;

import com.RobDev.VidaPlus.dto.healthProfessional.RecordProfessionalResponse;
import com.RobDev.VidaPlus.dto.healthProfessional.UpdateHpRequest;
import com.RobDev.VidaPlus.entities.HealthProfessional;
import com.RobDev.VidaPlus.dto.healthProfessional.CreateHpRequest;
import com.RobDev.VidaPlus.dto.healthProfessional.HpResponse;
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
}
