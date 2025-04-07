package com.RobDev.VidaPlus.mapper.medicalExamination;

import com.RobDev.VidaPlus.entities.MedicalExamination;
import com.RobDev.VidaPlus.dto.medicalExamination.CreateExamRequest;
import com.RobDev.VidaPlus.dto.medicalExamination.ExamResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicalExaminationMapper {

    @Mapping(target = "id" ,ignore = true)
    @Mapping(target = "consultation", ignore = true)
    MedicalExamination toCreateExam(CreateExamRequest request);

    ExamResponse toResponse(MedicalExamination entity);

    @Mapping(target = "id" ,ignore = true)
    @Mapping(target = "consultation", ignore = true)
    List<MedicalExamination> toCreateListRequest(List<CreateExamRequest> examinationList);
}
