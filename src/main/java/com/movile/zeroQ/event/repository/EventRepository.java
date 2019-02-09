package com.movile.zeroQ.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movile.zeroQ.event.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
}
