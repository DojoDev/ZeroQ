package com.movile.zeroQ.event.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movile.zeroQ.event.domain.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
	
}
