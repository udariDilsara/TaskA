package com.task.a.DTO;

import com.task.a.Entity.Drone;
import com.task.a.Entity.Medication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicationLoadRequest {

	
	private Drone drone;
	/*private Medication medication;

	public Medication getMedication() {
		return medication;
	}
	public void setMedication(Medication medication) {
		this.medication = medication;
	}*/
	public Drone getDrone() {
		return drone;
	}
	public void setDrone(Drone drone) {
		this.drone = drone;
	}	

}
