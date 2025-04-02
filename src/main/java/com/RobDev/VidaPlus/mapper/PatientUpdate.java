package com.RobDev.VidaPlus.mapper;

import com.RobDev.VidaPlus.Entities.Patient;
import com.RobDev.VidaPlus.dto.UpdatePatientRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PatientUpdate {

     void update(UpdatePatientRequest request, @MappingTarget Patient entity);
}
