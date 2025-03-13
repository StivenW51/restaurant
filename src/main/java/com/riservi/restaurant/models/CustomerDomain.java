package com.riservi.restaurant.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDomain {
    private int id;
    private String firstName;
    private String lastName;
    private String document;
    //private List<ReservationDomain> reservations;
}

