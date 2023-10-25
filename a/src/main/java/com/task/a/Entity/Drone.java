package com.task.a.Entity;
import java.util.HashSet;
import java.util.Set;
import com.task.a.Model.DroneModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;  // You can use a database-generated ID or your own logic for generating IDs.

	    @NotBlank
	    @Size(max = 100)
	    @Column(nullable = false)
	    private String serialNumber;

	    @NotNull
	    @Column(unique = true,nullable = false)
	    private DroneModel model;

	    @Transient
	    @Max(value = 500, message = "Weight limit cannot exceed 500 grams")
	    private double weightLimit;
	    
	    
	    @ManyToMany
	    @JoinTable(
	        name = "drone_medication",
	        joinColumns = @JoinColumn(name = "drone_id"),
	        inverseJoinColumns = @JoinColumn(name = "medication_id")
	    )
	    private Set<Medication> medications = new HashSet<>();
	    


}
