package com.projeckt.s2e4.repository;

import com.projeckt.s2e4.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
