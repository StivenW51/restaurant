package com.riservi.restaurant.controllers.mappers;

import com.riservi.restaurant.controllers.dto.in.ReservationInDTO;
import com.riservi.restaurant.controllers.dto.out.ReservationOutDTO;
import com.riservi.restaurant.models.ReservationDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationDomain toDomain(ReservationInDTO reservationInDTO);

    ReservationOutDTO toResponse(ReservationDomain domain);
}