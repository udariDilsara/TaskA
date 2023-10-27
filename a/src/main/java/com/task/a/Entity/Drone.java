package com.task.a.Entity;
import java.util.List;
import com.task.a.Model.DroneModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Drone { 
	    
	    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	    //@NotBlank
	   // @Size(max = 100)
	    //@Column(unique = true,nullable = false)
		@Id	
	    @Column( unique = true, nullable = false, length = 100)
	    private String serialNumber;

	    //@NotNull
	    @Column(nullable = false)
	    @Enumerated(EnumType.STRING)
	    private DroneModel model;

	    @Transient
	    @Max(value = 500, message = "Weight limit cannot exceed 500 grams")
	    private double weightLimit;
	    
	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "drone_serial_number_fk", referencedColumnName = "serialNumber")
	    private List <Medication> medications;
	    

}
