package com.task.a.DTO;

import com.task.a.Model.DroneModel;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DroneDTO {
	

    @NotBlank
    @Size(max = 100)
	private String serialNumber;
    @NotNull
	private DroneModel model;
    @Max(value = 500, message = "Weight limit cannot exceed 500 grams")
	private double weightLimit;
}
