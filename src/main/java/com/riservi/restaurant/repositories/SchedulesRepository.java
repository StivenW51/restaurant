package com.riservi.restaurant.repositories;

import com.riservi.restaurant.entities.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface SchedulesRepository extends JpaRepository<ScheduleEntity, Integer> {
}

