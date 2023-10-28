package com.task.a.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Medication {
		
	 
		@Id
	    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	    //@NotBlank
	    //@Column(unique = true,nullable = false)
	    @Pattern(regexp = "^[A-Z_0-9]+$", message = "Code can only contain uppercase letters, '_', and numbers")
	    private String code;

	    //@NotBlank
	    @Pattern(regexp = "^[a-zA-Z0-9-_]+$", message = "Name can only contain letters, numbers, '-', and '_'")
	    private String name;
	    
	    //@Column(nullable = false)
	    private double weight;
	    
	    @ManyToOne(fetch =FetchType.EAGER,cascade = CascadeType.ALL)
	    @JoinColumn(name = "drone_serial_number_fk", referencedColumnName = "serial_number")
	    @JsonIgnore
	    private Drone drone;

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

		public Drone getDrone() {
			return drone;
		}

		public void setDrone(Drone drone) {
			this.drone = drone;
		}

	    

}
