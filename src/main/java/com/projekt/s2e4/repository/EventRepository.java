package com.projekt.s2e4.repository;

import com.projekt.s2e4.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
