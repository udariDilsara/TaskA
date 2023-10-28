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

import com.task.a.DTO.MedicationDTO;
import com.task.a.Service.MedicationService;

@RestController
@RequestMapping(value = "/api/v1/medication")
@CrossOrigin
public class MedicationController {
	@Autowired
	private MedicationService medicationService;
	
	@PostMapping("/save_medications")
	public MedicationDTO savemedication(@RequestBody MedicationDTO medicationDTO) {
		return medicationService.savemedication(medicationDTO) ;
	}
	
	@GetMapping("/get_medications")
	public List<MedicationDTO> getMedication() {
		return medicationService.getAllMedications();
	}

	//update method not working
	@PutMapping("/update_medication")
	public MedicationDTO updateMedication(@RequestBody MedicationDTO medicationDTO) {
		return medicationService.savemedication(medicationDTO) ;
	}
	@DeleteMapping("/delete_medication")
	public MedicationDTO deleteMedication(@RequestBody MedicationDTO medicationDTO) {
		return medicationService.savemedication(medicationDTO) ;
	}	
/*	@GetMapping("/get_medication_by_code/{code}")
	public MedicationDTO getMedicationByCode(@PathVariable String code) {
		return medicationService.getMedicationByCode(code);
	}
	*/

}
