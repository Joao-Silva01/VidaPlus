package com.RobDev.VidaPlus.mapper;

import com.RobDev.VidaPlus.Entities.Prescription;
import com.RobDev.VidaPlus.dto.prescription.PrescriptionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PrescriptionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "consultation", ignore = true)
    Prescription toCreatePrescription (PrescriptionRequest request);
}
