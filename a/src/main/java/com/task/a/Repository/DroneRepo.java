package com.task.a.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.task.a.Entity.Drone;

public interface DroneRepo extends JpaRepository<Drone, Integer> {

	@Query(value = "SELECT * FROM DRONE WHERE SERIAL_NUMBER = ?1",nativeQuery = true)
	Drone getDroneByDroneSerialNUmber(Integer serial_number);
	
	@Query(value = "SELECT * FROM DRONE WHERE WEIGHT_LIMIT = ?1 LIMIT 1",nativeQuery = true)
	List<Drone> getDroneByWeightLimit(Double weight_limit);
	
}
