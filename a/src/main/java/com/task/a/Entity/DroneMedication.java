package com.task.a.Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "drone_medication")
public class DroneMedication implements Serializable {
	

	    @Id
	    @ManyToOne
	    @JoinColumn(name = "drone_id")
	    private Drone drone;

	    @Id
	    @ManyToOne
	    @JoinColumn(name = "medication_id")
	    private Medication medication;

	    @PositiveOrZero
	    private int weight; // The third column in the join table


}
