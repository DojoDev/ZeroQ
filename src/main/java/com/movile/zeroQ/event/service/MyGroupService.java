package com.movile.zeroQ.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movile.zeroQ.event.domain.MyGroup;
import com.movile.zeroQ.event.repository.GroupRepository;

@Service
public class MyGroupService {
	
	@Autowired
	private GroupRepository eventRepository;
	
	public void insertGroup(MyGroup group) {

		eventRepository.save(group);

	}

}
