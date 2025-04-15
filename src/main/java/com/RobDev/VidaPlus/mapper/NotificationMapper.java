package com.RobDev.VidaPlus.mapper;

import com.RobDev.VidaPlus.dto.notification.NotificationRequest;
import com.RobDev.VidaPlus.entities.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NotificationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "patient", ignore = true)
    Notification toRequest(NotificationRequest request);
}
