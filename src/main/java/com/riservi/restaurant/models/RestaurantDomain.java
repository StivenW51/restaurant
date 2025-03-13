package com.riservi.restaurant.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDomain {
    private Integer id;
    private String name;
    private LocalTime openingHours;
    private LocalTime closingHours;
    private List<ReservationDomain> reservations;
    private List<ScheduleDomain> schedules;
    private List<TableDomain> tables;
}

