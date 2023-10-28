package com.task.a.DTO;

import com.task.a.Model.DroneModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DroneDTO {
	
	private int serial_number;
	private DroneModel model;
	private double weight_limit;
	
	public int getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(int serial_number) {
		this.serial_number = serial_number;
	}
	public DroneModel getModel() {
		return model;
	}
	public void setModel(DroneModel model) {
		this.model = model;
	}
	public double getWeight_limit() {
		return weight_limit;
	}
	public void setWeight_limit(double weight_limit) {
		this.weight_limit = weight_limit;
	}

}
