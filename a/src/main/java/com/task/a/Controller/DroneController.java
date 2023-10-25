package com.task.a.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.a.DTO.DroneDTO;
import com.task.a.Service.DroneService;

@RestController
@RequestMapping("/api/v1/drone")
@CrossOrigin
public class DroneController {
	
	@Autowired
	private DroneService droneService;
	
	
	
	@PostMapping("/saveDrone")
	public boolean savedrone(@RequestBody DroneDTO droneDTO) {
		droneService.savedrone(droneDTO);
		return true;
	}
}
