package com.riservi.restaurant.controllers.dto.in;

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
public class ReservationInDTO {
    public int id;
    public LocalDate date;
    public LocalTime time;
    public int tableNumber;
    public int customerId;
    public int restaurantId;
}

