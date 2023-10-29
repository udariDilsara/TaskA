package com.task.a.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.a.DTO.MedicationDTO;
import com.task.a.DTO.MedicationLoadRequest;
import com.task.a.Entity.Drone;
import com.task.a.Entity.Medication;
import com.task.a.Service.DroneService;
import com.task.a.Service.MedicationService;

@RestController
@RequestMapping(value = "/api/v1/medication_load")
@CrossOrigin
public class MedicationLoadController {
	@Autowired
	private MedicationService medicationService;
	@Autowired
	private DroneService droneService;
	
	/*@PostMapping("/save_medication_load")
	public MedicationLoadRequest loadmedication(@RequestBody MedicationLoadRequest medicationLoadRequest) {
		return medicationService.loadmedication(medicationLoadRequest) ;
	}
	*/
	/*@PostMapping("/save_medication_load")
	public ResponseEntity<String> loadmedication(@RequestBody MedicationLoadRequest medicationLoadRequest) {
	    MedicationLoadRequest result = medicationService.loadmedication(medicationLoadRequest);
	    if (result != null) {
	        return ResponseEntity.ok("Medication loaded successfully");
	    } else {
	        return ResponseEntity.badRequest().body("Failed to load medication");
	    }
	}*/

    /*@PostMapping("/load_medication")
    public ResponseEntity<String> loadMedication(@RequestBody MedicationLoadRequest request) {
        MedicationLoadRequest result = medicationService.loadMedication(request);
        if (result != null) {
            return ResponseEntity.ok("Medication and Drone details loaded successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to load Medication and Drone details");
        }
    }*/
	/*@PostMapping("/load_medications")
	public MedicationLoadRequest loadmedication(@RequestBody MedicationLoadRequest medicationLoadRequest) {
		return medicationService.loadmedication(medicationLoadRequest) ;
	}*/
	@PostMapping("/save_medications")
	public MedicationDTO savemedication(@RequestBody MedicationDTO medicationDTO) {
		return medicationService.savemedication(medicationDTO) ;
	}
	

}
