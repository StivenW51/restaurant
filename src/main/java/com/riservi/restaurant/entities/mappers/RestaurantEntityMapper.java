package com.riservi.restaurant.entities.mappers;

import com.riservi.restaurant.entities.RestaurantEntity;
import com.riservi.restaurant.models.RestaurantDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantEntityMapper {
    RestaurantDomain toDomain(RestaurantEntity entity);

    RestaurantEntity toEntity(RestaurantDomain domain);
}
