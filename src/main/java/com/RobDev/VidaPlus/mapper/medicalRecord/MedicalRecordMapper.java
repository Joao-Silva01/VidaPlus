package com.RobDev.VidaPlus.mapper.medicalRecord;

import com.RobDev.VidaPlus.dto.medicalRecord.CreateMedicalRecordRequest;
import com.RobDev.VidaPlus.dto.medicalRecord.CreateMedicalRecordResponse;
import com.RobDev.VidaPlus.dto.medicalRecord.MedicalRecordResponse;
import com.RobDev.VidaPlus.entities.MedicalRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicalRecordMapper {

    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "professionals", ignore = true)
    MedicalRecord toCreateEntity(CreateMedicalRecordRequest request);

    CreateMedicalRecordResponse toCreateResponse(MedicalRecord entity);

    @Mapping(target = "professionals", ignore = true)
    MedicalRecordResponse toResponse(MedicalRecord entity);
}
