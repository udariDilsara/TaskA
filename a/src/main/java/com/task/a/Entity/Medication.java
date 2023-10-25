package com.task.a.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
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
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @NotBlank
	    @Pattern(regexp = "^[a-zA-Z0-9-_]+$", message = "Name can only contain letters, numbers, '-', and '_'")
	    private String name;


	    @NotBlank
	    @Pattern(regexp = "^[A-Z_0-9]+$", message = "Code can only contain uppercase letters, '_', and numbers")
	    private String code;

	    // Define the many-to-many relationship with Drone
	    @ManyToMany(mappedBy = "medications")
	    private Set<Drone> drones = new  HashSet<>();
	    

}
