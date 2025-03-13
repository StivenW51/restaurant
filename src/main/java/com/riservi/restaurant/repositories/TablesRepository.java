package com.riservi.restaurant.repositories;

import com.riservi.restaurant.entities.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TablesRepository extends JpaRepository<TableEntity, Integer> {

    List<TableEntity> findAvailableTablesWithSchedules();

    Optional<TableEntity> findByNumTable(int numTable);
}








