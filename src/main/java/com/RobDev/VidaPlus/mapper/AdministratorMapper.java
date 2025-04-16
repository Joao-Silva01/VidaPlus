package com.RobDev.VidaPlus.mapper;

import com.RobDev.VidaPlus.dto.administrator.AdminRequest;
import com.RobDev.VidaPlus.dto.administrator.AdminResponse;
import com.RobDev.VidaPlus.dto.administrator.UpdateAdminRequest;
import com.RobDev.VidaPlus.entities.Administrator;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AdministratorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "reports", ignore = true)
    @Mapping(target = "password", ignore = true)
    Administrator toRequest(AdminRequest request);

    AdminResponse toResponse(Administrator entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toUpdateRequest(UpdateAdminRequest request, @MappingTarget Administrator entity);
}
