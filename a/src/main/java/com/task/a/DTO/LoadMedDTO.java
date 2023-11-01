package com.task.a.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

@Data
public class LoadMedDTO {
	
	private String code;

    private String name;
    
    private double weight;
    
    private int serial_number;
	
    public int getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(int serial_number) {
		this.serial_number = serial_number;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}


}
