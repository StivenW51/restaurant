package com.riservi.restaurant.models;

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
public class AvailableSchedulesDomain {
    public int restaurantId;
    public int tableNumber;
    public LocalDate date;
    public LocalTime time;
}
