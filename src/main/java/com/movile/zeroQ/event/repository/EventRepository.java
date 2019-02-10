package com.movile.zeroQ.event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movile.zeroQ.event.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

	List<Event> findByName(String name);
	
}
