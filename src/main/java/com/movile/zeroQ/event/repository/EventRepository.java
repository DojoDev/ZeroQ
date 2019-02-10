package com.movile.zeroQ.event.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movile.zeroQ.event.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
	
	@Query("select e from Event e where e.id = :id")
	Optional<Event> findById(@Param("id")Integer id);
	
}
