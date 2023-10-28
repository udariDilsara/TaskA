package com.task.a.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.a.DTO.DroneDTO;
import com.task.a.DTO.MedicationDTO;
import com.task.a.Entity.Drone;
import com.task.a.Entity.Medication;
import com.task.a.Repository.DroneRepo;
import com.task.a.Repository.MedicationRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MedicationService {
	@Autowired
	private MedicationRepo medicationRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public MedicationDTO savemedication(MedicationDTO medicationDTO) {
        try {
            Medication d = modelMapper.map(medicationDTO,Medication.class);
            
            medicationRepo.save(d);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicationDTO;
	}
	
    public List<MedicationDTO> getAllMedications(){
    	List<Medication> medicationList = medicationRepo.findAll();
    	return modelMapper.map(medicationList,new TypeToken<List<MedicationDTO>>() {}.getType());
    }
    
    public MedicationDTO updateMedication(MedicationDTO medicationDTO) {
    	medicationRepo.save(modelMapper.map(medicationDTO, Medication.class));
    	return medicationDTO;
    }

    
    public MedicationDTO deleteDrone(MedicationDTO medicationDTO) {
    	medicationRepo.delete(modelMapper.map(medicationDTO, Medication.class));
    	return medicationDTO;
    }
    
    
    //check this, this funtion need
   /* public MedicationDTO getMedicationByCode(String code) {
    	Medication medication = medicationRepo.getMedicationByCode(code);
  	  	return modelMapper.map(medication,MedicationDTO.class );
    }*/
    

}
