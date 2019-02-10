package com.movile.zeroQ.event.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.movile.zeroQ.event.domain.Event;
import com.movile.zeroQ.event.service.EventService;

@RestController
@RequestMapping("/events")
public class EventResource {

	@Autowired
	private EventService eventService;
	
	@GetMapping
	public List<Event> list() {
		return eventService.listAll();
	}

	@GetMapping("/{id}")
	public Event getEvent(@PathVariable("id") Integer id) {
		return eventService.findById(id).orElseGet(Event::new);
	}
	
	@GetMapping("/name={name}")
	public List<Event> getEvent(@PathVariable("name") String name) {
		return eventService.findByName(name);
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable("id") Integer id){
		eventService.remove(id);
	}
	
	@PutMapping("/{id}")
	public void remove(@PathVariable("id") Integer id, @Valid @RequestBody Event event){
		eventService.update(id,event);
	}
	
	@PostMapping
	public ResponseEntity<String> save(@Valid @RequestBody Event event, BindingResult result){

		if(result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		event.setId(0);
		eventService.save(event);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(event.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
}
