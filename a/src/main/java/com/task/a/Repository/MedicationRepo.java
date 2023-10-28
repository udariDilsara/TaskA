package com.task.a.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.task.a.DTO.MedicationDTO;

import com.task.a.Entity.Medication;

public interface MedicationRepo extends JpaRepository<Medication,String>{
	
	@Query(value = "SELECT code, name, weight FROM MEDICATION WHERE CODE = ?1",nativeQuery = true)
	MedicationDTO getMedicationByCode(String code);
	
	


}
