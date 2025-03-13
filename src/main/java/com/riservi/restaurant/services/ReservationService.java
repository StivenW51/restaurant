package com.riservi.restaurant.services;

import com.riservi.restaurant.entities.CustomerEntity;
import com.riservi.restaurant.entities.ReservationEntity;
import com.riservi.restaurant.entities.RestaurantEntity;
import com.riservi.restaurant.entities.TableEntity;
import com.riservi.restaurant.entities.mappers.ReservationEntityMapper;
import com.riservi.restaurant.models.AvailableSchedulesDomain;
import com.riservi.restaurant.models.ReservationDomain;
import com.riservi.restaurant.repositories.CustomerRepository;
import com.riservi.restaurant.repositories.ReservationRepository;
import com.riservi.restaurant.repositories.RestaurantRepository;
import com.riservi.restaurant.repositories.TablesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    private CustomerRepository customerRepository;

    private RestaurantRepository restaurantRepository;

    private ReservationEntityMapper reservationEntityMapper;

    private TablesRepository tablesRepository;

    public ReservationDomain createReservation(ReservationDomain reservationDomain) throws Exception {
        ReservationDomain domain = reservationDomain;
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(domain.getCustomer().getId());
        Optional<RestaurantEntity> optionalRestaurant = restaurantRepository.findById(0);
        Optional<TableEntity> optionalTableEntity = tablesRepository.findByNumTable(0);

        ReservationEntity reservationEntity = reservationEntityMapper.toEntity(reservationDomain);

        if(optionalCustomer.isEmpty()){
            throw new Exception("Customer doesn't exists");
        }

        if(optionalRestaurant.isEmpty()){
            throw new Exception("Restaurant doesn't exists");
        }

        if(optionalTableEntity.isEmpty()){
            throw new Exception("table doesn't exists");
        }

        validateReservation(reservationDomain);

        reservationEntity.setCustomer(optionalCustomer.get());
        reservationEntity.setRestaurant(optionalRestaurant.get());

        ReservationEntity savedEntity = reservationRepository.save(reservationEntity);
        return reservationEntityMapper.toDomain(savedEntity);
    }

    public ReservationDomain getReservation(int id) throws Exception {
        Optional<ReservationEntity> optionalReservation = reservationRepository.findById(id);

        if(optionalReservation.isEmpty()){
            throw new Exception("Reservation not found");
        }

        return reservationEntityMapper.toDomain(optionalReservation.get());
    }

    public List<ReservationDomain> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(reservationEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    public ReservationDomain updateReservation(ReservationDomain reservationDomain) throws Exception {
        Optional<ReservationEntity> optionalReservation = reservationRepository.findById(reservationDomain.getId());
        Optional<TableEntity> optionalTableEntity = tablesRepository.findByNumTable(reservationDomain.getTable().getNumTable());

        if(optionalReservation.isEmpty()){
            throw new Exception("Reservation not found");
        }

        if(optionalTableEntity.isEmpty()){
            throw new Exception("table doesn't exists");
        }

        validateReservation(reservationDomain);

        ReservationEntity reservationEntity = optionalReservation.get();

        reservationEntity.setDate(reservationDomain.getDate());
        reservationEntity.setTime(reservationDomain.getTime());
        reservationEntity.setTable(optionalTableEntity.get());

        ReservationEntity updatedEntity = reservationRepository.save(reservationEntity);
        return reservationEntityMapper.toDomain(updatedEntity);
    }

    public List<ReservationDomain> getReservationByDate(LocalDate date) throws Exception {
        List<ReservationEntity> reservationEntityList = reservationRepository.findByDate(date);

        if(reservationEntityList.isEmpty()){
            throw new Exception("Reservation not found");
        }

        return reservationEntityList.stream()
                .map(reservationEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    public List<AvailableSchedulesDomain> checkAvailableSchedules(int restaurantId, LocalDate date, LocalTime time) throws Exception {
        List<AvailableSchedulesDomain> availableSchedulesDomainList = new ArrayList<>();

        List<ReservationDomain> reservationDomainList = getReservationByDate(date);


        return availableSchedulesDomainList;
    }

    public void validateReservation(ReservationDomain reservationDomainIn) throws Exception {

        List<ReservationDomain> reservationDomainList = getReservationByDate(reservationDomainIn.getDate());

        for(ReservationDomain reservationDomain : reservationDomainList){
            if(reservationDomain.getId() != reservationDomainIn.getId()){
                if(reservationDomain.getTable().getNumTable() == reservationDomainIn.getTable().getNumTable()){
                    if(reservationDomain.getTime().equals(reservationDomainIn.getTime())){
                        throw new Exception("reserved table");
                    }
                }
            }
        }


    }
}
