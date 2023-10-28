package com.task.a.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.a.DTO.DroneDTO;
import com.task.a.Service.DroneService;

@RestController
@RequestMapping(value = "/api/v1/drone")
@CrossOrigin
public class DroneController {
	
	@Autowired
	private DroneService droneService;
	
	/*@GetMapping("/get_drone")
	public String getDrone() {
		return "Drone 1";
	}*/
	
	/*@PostMapping("/save_drones")
	public String saveDrone() {
		return "Save Drone 1";
	}
	@PutMapping("/update_drone")
	public String updateDrone() {
		return "Update Drone 1";
	}
	@DeleteMapping("/delete_drone")
	public String deleteDrone() {
		return "Delete Drone 1";
	}*/
	
	@PostMapping("/save_drones")
	public DroneDTO savedrone(@RequestBody DroneDTO droneDTO) {
		return droneService.savedrone(droneDTO) ;
	}
	@GetMapping("/get_drones")
	public List<DroneDTO> getDrone() {
		return droneService.getAllDrones();
	}
	@PutMapping("/update_drone")
	public DroneDTO updateDrone(@RequestBody DroneDTO droneDTO) {
		return droneService.savedrone(droneDTO) ;
	}
	@DeleteMapping("/delete_drone")
	public DroneDTO deleteDrone(@RequestBody DroneDTO droneDTO) {
		return droneService.savedrone(droneDTO) ;
	}	
	@GetMapping("/get_drones_by_serial_number/{serial_number}")
	public DroneDTO getDroneBySerialNumber(@PathVariable Integer serial_number ) {
		return droneService.getDroneBySerialNumber(serial_number);
	}
	
	//you will get only one drone
	@GetMapping("/get_drones_by_weight_limit/{weight_limit}")
	public List<DroneDTO> getDroneByWeightLimit(@PathVariable Double weight_limit ) {
		return droneService.getDroneByWeightLimit(weight_limit);
	}
}
