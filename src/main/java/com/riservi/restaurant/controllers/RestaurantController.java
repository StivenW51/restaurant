package com.riservi.restaurant.controllers;

import com.riservi.restaurant.controllers.dto.in.ReservationInDTO;
import com.riservi.restaurant.controllers.dto.out.AvailableSchedulesOutDTO;
import com.riservi.restaurant.controllers.dto.out.ReservationOutDTO;
import com.riservi.restaurant.controllers.mappers.ReservationMapper;
import com.riservi.restaurant.controllers.mappers.SchedulesMapper;
import com.riservi.restaurant.models.AvailableSchedulesDomain;
import com.riservi.restaurant.models.ReservationDomain;
import com.riservi.restaurant.services.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class RestaurantController {
    private  ReservationService reservationService;

    private  ReservationMapper reservationMapper;

    private  SchedulesMapper schedulesMapper;

    @PostMapping("/create")
    public ResponseEntity<ReservationOutDTO> createReservation(@RequestBody ReservationInDTO reservationInDTO){
        ReservationOutDTO reservationOutDTO = new ReservationOutDTO();

        try {
            ReservationDomain reservationDomain = reservationService.createReservation(reservationMapper.toDomain(reservationInDTO));
            reservationOutDTO = reservationMapper.toResponse(reservationDomain);
            return ResponseEntity.ok(reservationOutDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(reservationOutDTO);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ReservationOutDTO>> getAllReservations(){
        List<ReservationOutDTO> reservationOutDTOList = new ArrayList<>();

        try {
            List<ReservationDomain> reservationDomainList = reservationService.getAllReservations();
            reservationOutDTOList = reservationDomainList.stream()
                    .map(reservationMapper::toResponse)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(reservationOutDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(reservationOutDTOList);
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<ReservationOutDTO> getReservationById(@RequestParam int id){
        ReservationOutDTO reservationOutDTO = new ReservationOutDTO();

        try {
            ReservationDomain reservationDomain = reservationService.getReservation(id);
            reservationOutDTO = reservationMapper.toResponse(reservationDomain);
            return ResponseEntity.ok(reservationOutDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(reservationOutDTO);
        }
    }

    @GetMapping("/getByDate")
    public ResponseEntity<List<ReservationOutDTO>> getReservationByDate(@RequestParam LocalDate date){
        List<ReservationOutDTO> reservationOutDTOList = new ArrayList<>();

        try {
            List<ReservationDomain> reservationDomainList = reservationService.getReservationByDate(date);
            reservationOutDTOList =  reservationDomainList.stream()
                    .map(reservationMapper::toResponse)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(reservationOutDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(reservationOutDTOList);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ReservationOutDTO> updateReservation(@RequestBody ReservationInDTO reservationInDTO){
        ReservationOutDTO reservationOutDTO = new ReservationOutDTO();

        try {
            ReservationDomain reservationDomain = reservationService.updateReservation(reservationMapper.toDomain(reservationInDTO));
            reservationOutDTO = reservationMapper.toResponse(reservationDomain);
            return ResponseEntity.ok(reservationOutDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(reservationOutDTO);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ReservationOutDTO> deleteReservationById(@RequestParam int id){
        ReservationOutDTO reservationOutDTO = new ReservationOutDTO();

        try {
            ReservationDomain reservationDomain = reservationService.getReservation(id);
            reservationOutDTO = reservationMapper.toResponse(reservationDomain);
            return ResponseEntity.ok(reservationOutDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(reservationOutDTO);
        }
    }


    @GetMapping("/checkAvailableSchedules")
    public ResponseEntity<List<AvailableSchedulesOutDTO>> checkAvailableSchedules(@RequestParam int restaurantId,
                                                                                  @RequestParam LocalDate date,
                                                                                  @RequestParam LocalTime time){
        List<AvailableSchedulesOutDTO> availableSchedulesOutDTOList = new ArrayList<>();

        try {
            List<AvailableSchedulesDomain> availableSchedulesDomain = reservationService.checkAvailableSchedules(restaurantId, date, time);
            availableSchedulesOutDTOList = availableSchedulesDomain.stream()
                    .map(schedulesMapper::toResponse)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(availableSchedulesOutDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(availableSchedulesOutDTOList);
        }
    }
}
