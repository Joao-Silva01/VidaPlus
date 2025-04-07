package com.RobDev.VidaPlus.mapper.patient;

import com.RobDev.VidaPlus.entities.Patient;
import com.RobDev.VidaPlus.dto.patiente.UpdatePatientRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PatientUpdate {

     void requestUpdate(UpdatePatientRequest request, @MappingTarget Patient entity);
}
