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
import jakarta.validation.constraints.Max;
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
		//@GeneratedValue(strategy = GenerationType.TABLE)
	    //@Column( unique = true, nullable = false, length = 100)
	    private int serial_number;


		//@NotNull
	    //@Column
	    @Enumerated(EnumType.STRING)
	    private DroneModel model;

	    //@Transient
	    //@Max(value = 500, message = "Weight limit cannot exceed 500 grams")
	    private double weight_limit;
	    
	    
	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "drone_serial_number_fk", referencedColumnName = "serial_number")
	    private List <Medication> medications;

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

		public double getWeightL_limit() {
			return weight_limit;
		}

		public void setWeight_limit(double weight_limit) {
			this.weight_limit = weight_limit;
		}

		public List<Medication> getMedications() {
			return medications;
		}

		public void setMedications(List<Medication> medications) {
			this.medications = medications;
		}



	    

}
