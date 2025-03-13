package com.riservi.restaurant.entities;

import jakarta.persistence.*;
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
@Entity
@Table(name = "RESERVATIONS")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date", nullable = false, length = 255)
    private LocalDate date;

    @Column(name = "time", nullable = false, length = 255)
    private LocalTime time;

    @Column(name = "status", nullable = false, length = 255)
    String status;

    @OneToOne
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private TableEntity table;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private RestaurantEntity restaurant;

    @OneToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    private ScheduleEntity schedule;
}
