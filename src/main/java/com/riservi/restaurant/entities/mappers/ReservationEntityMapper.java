package com.riservi.restaurant.entities.mappers;

import com.riservi.restaurant.entities.ReservationEntity;
import com.riservi.restaurant.models.ReservationDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationEntityMapper {
    ReservationDomain toDomain(ReservationEntity entity);
    ReservationEntity toEntity(ReservationDomain domain);
}