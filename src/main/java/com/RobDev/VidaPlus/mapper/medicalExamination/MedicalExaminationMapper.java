package com.RobDev.VidaPlus.mapper.medicalExamination;

import com.RobDev.VidaPlus.dto.medicalExamination.UpdateExamRequest;
import com.RobDev.VidaPlus.entities.MedicalExamination;
import com.RobDev.VidaPlus.dto.medicalExamination.CreateExamRequest;
import com.RobDev.VidaPlus.dto.medicalExamination.ExamResponse;
import org.mapstruct.*;

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

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void requestUpdate(UpdateExamRequest request, @MappingTarget MedicalExamination entity);
}
