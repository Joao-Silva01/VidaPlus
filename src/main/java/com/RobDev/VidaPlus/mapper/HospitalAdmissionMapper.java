package com.RobDev.VidaPlus.mapper;

import com.RobDev.VidaPlus.Entities.HospitalAdmission;
import com.RobDev.VidaPlus.dto.hospitalAdmission.HospitalAdmissionRequest;
import com.RobDev.VidaPlus.dto.hospitalAdmission.HospitalAdmissionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HospitalAdmissionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "consultation", ignore = true)
    HospitalAdmission toCreateEntity(HospitalAdmissionRequest request);

    HospitalAdmissionResponse toResponse(HospitalAdmission entity);

}
