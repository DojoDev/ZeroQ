package com.movile.zeroQ.event.service;

import java.util.List;
import java.util.Optional;

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

	public Optional<Event> findById(Integer id) {
		return eventRepository.findById(id);
	}

	public void save(Event event) {
		eventRepository.save(event);
		
	}

	public void remove(Integer id) {
		Optional<Event> event = eventRepository.findById(id);
		event.ifPresent(ev ->{
			eventRepository.delete(ev);
		});
	}

}
