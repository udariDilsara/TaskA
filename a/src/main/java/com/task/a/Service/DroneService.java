package com.task.a.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.a.DTO.DroneDTO;
import com.task.a.Entity.Drone;
import com.task.a.Repository.DroneRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DroneService {
	
	@Autowired
	private DroneRepo droneRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public DroneDTO savedrone(DroneDTO droneDTO) {
		droneRepo.save(modelMapper.map(droneDTO, Drone.class));
		return droneDTO;
	}
}
