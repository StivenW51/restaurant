package com.riservi.restaurant.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDomain {
    private Integer id;
    private LocalTime hour;
    private Integer restaurantId;
}
