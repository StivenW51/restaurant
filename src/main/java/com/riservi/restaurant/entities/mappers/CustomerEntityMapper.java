package com.riservi.restaurant.entities.mappers;

import com.riservi.restaurant.entities.CustomerEntity;
import com.riservi.restaurant.models.CustomerDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerDomain toDomain(CustomerEntity entity);
    CustomerEntity toEntity(CustomerDomain domain);
}
