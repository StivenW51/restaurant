package com.riservi.restaurant.controllers.dto.out;

import com.riservi.restaurant.models.CustomerDomain;
import com.riservi.restaurant.models.RestaurantDomain;
import com.riservi.restaurant.models.ScheduleDomain;
import com.riservi.restaurant.models.TableDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationOutDTO {
    private int id;
    private LocalDate date;
    private LocalTime time;
    private int restaurantId;
    private String status;
    private TableDomain table;
    private CustomerDomain customer;
    private RestaurantDomain restaurant;
    private ScheduleDomain schedule;
}

