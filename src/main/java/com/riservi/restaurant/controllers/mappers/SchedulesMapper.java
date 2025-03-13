package com.riservi.restaurant.controllers.mappers;

import com.riservi.restaurant.controllers.dto.out.AvailableSchedulesOutDTO;
import com.riservi.restaurant.models.AvailableSchedulesDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchedulesMapper {
    AvailableSchedulesOutDTO toResponse(AvailableSchedulesDomain availableSchedulesDomain);
}
