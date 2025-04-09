package com.RobDev.VidaPlus.mapper.hospitalAdmission;

import com.RobDev.VidaPlus.dto.hospitalAdmission.UpdateHospitalAdmissionRequest;
import com.RobDev.VidaPlus.entities.HospitalAdmission;
import com.RobDev.VidaPlus.dto.hospitalAdmission.CreateHospitalAdmissionRequest;
import com.RobDev.VidaPlus.dto.hospitalAdmission.HospitalAdmissionResponse;
import org.mapstruct.*;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HospitalAdmissionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "consultation", ignore = true)
    HospitalAdmission toCreateEntity(CreateHospitalAdmissionRequest request);

    HospitalAdmissionResponse toResponse(HospitalAdmission entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void requestUpdate(UpdateHospitalAdmissionRequest request, @MappingTarget HospitalAdmission entity);
}
