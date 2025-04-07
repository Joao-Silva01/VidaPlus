package com.RobDev.VidaPlus.mapper.hospitalAdmission;

import com.RobDev.VidaPlus.entities.HospitalAdmission;
import com.RobDev.VidaPlus.dto.hospitalAdmission.CreateHospitalAdmissionRequest;
import com.RobDev.VidaPlus.dto.hospitalAdmission.HospitalAdmissionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HospitalAdmissionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "consultation", ignore = true)
    HospitalAdmission toCreateEntity(CreateHospitalAdmissionRequest request);

    HospitalAdmissionResponse toResponse(HospitalAdmission entity);

}
