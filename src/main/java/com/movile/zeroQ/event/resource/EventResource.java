package com.movile.zeroQ.event.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movile.zeroQ.event.domain.Event;
import com.movile.zeroQ.event.service.EventService;

@RestController
@RequestMapping("events/")
public class EventResource {

	@Autowired
	private EventService eventService;
	
	@GetMapping
	public List<Event> list() {
		return eventService.listAll();
	}

	@GetMapping("/{id}")
	public Event getEvent(Integer id) {
		return eventService.findById(id);
	}
}
