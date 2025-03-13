package com.riservi.restaurant.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class ReservationDomain {
    private int id;
    private LocalDate date;
    private LocalTime time;
    private String status;
    private TableDomain table;
    private CustomerDomain customer;
    private RestaurantDomain restaurant;
    private ScheduleDomain schedule;
}
