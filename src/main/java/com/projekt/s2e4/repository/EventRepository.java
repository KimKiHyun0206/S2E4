package com.projekt.s2e4.repository;

import com.projekt.s2e4.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {

    @Query(
            value = "update event"+
                    "set status = false" +
                    "where end_at = time >: time"
            ,nativeQuery = true
    )public void updateStatusToFalse(@Param(value = "time")LocalDate date);
}
