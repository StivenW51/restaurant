package com.riservi.restaurant.controllers.dto.out;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class AvailableSchedulesOutDTO {
    public int restaurantId;
    public int tableNumber;
    public LocalDate date;
    public LocalTime time;
}
