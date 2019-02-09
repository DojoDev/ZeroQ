package com.movile.zeroQ.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movile.zeroQ.event.domain.Event;
import com.movile.zeroQ.event.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	
	public List<Event> listAll() {
		return eventRepository.findAll();
	}

	public Event findById(Integer id) {
		return eventRepository.findById(id).orElseGet(Event::new);
	}

}
