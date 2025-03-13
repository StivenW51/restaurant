package com.riservi.restaurant.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TableDomain {
    private Integer id;
    private String description;
    private int numTable;
    private Integer restaurantId;
}

