package com.task.a.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	    //@NotBlank
	    @Column(unique = true,nullable = false)
	    @Pattern(regexp = "^[A-Z_0-9]+$", message = "Code can only contain uppercase letters, '_', and numbers")
	    private String code;

	    //@NotBlank
	    @Pattern(regexp = "^[a-zA-Z0-9-_]+$", message = "Name can only contain letters, numbers, '-', and '_'")
	    private String name;
	    
	    @Column(nullable = false)
	    private double weight;

	    
	    

}
