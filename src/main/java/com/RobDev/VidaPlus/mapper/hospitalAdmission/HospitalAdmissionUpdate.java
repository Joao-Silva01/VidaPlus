package com.RobDev.VidaPlus.mapper.hospitalAdmission;

import com.RobDev.VidaPlus.dto.hospitalAdmission.UpdateHospitalAdmissionRequest;
import com.RobDev.VidaPlus.entities.HospitalAdmission;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HospitalAdmissionUpdate {

    void requestUpdate(UpdateHospitalAdmissionRequest request, @MappingTarget HospitalAdmission entity);
}
