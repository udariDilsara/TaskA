package com.task.a.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.task.a.DTO.DroneDTO;
import com.task.a.DTO.LoadMedDTO;
import com.task.a.DTO.MedicationDTO;
import com.task.a.Entity.Drone;
import com.task.a.Entity.Medication;
import com.task.a.Exception.ResourceNotFoundException;
import com.task.a.Repository.DroneRepo;
import com.task.a.Repository.MedicationRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MedicationService {
	@Autowired
	private MedicationRepo medicationRepo;
	@Autowired
	private DroneRepo droneRepo;
	
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
	public Medication loadmedicationnew(LoadMedDTO loadMedDTO) {
		   Medication medication = new Medication();
		    
		    // Copy fields from LoadMedDTO to Medication
		    medication.setCode(loadMedDTO.getCode());
		    medication.setName(loadMedDTO.getName());
		    medication.setWeight(loadMedDTO.getWeight());

		   Drone drone = droneRepo.getDroneByDroneSerialNUmber(loadMedDTO.getSerial_number());
		    // Now you can return the Medication instance
		   medication.setDrone(drone);
		   medicationRepo.save(medication);
		    return medication;
	}
	public Medication loadmedication(MedicationDTO medicationDTO, int droneSerialNumber) {
		 // Map MedicationDTO to Medication
        Medication medication = modelMapper.map(medicationDTO, Medication.class);

     // Find the Drone by serial number
        Drone drone = droneRepo.findById(droneSerialNumber)
            .orElseThrow(() -> new ResourceNotFoundException("Drone not found"));


        // Assign the Drone to the Medication
        medication.setDrone(drone);

        // Save the Medication
        return medicationRepo.save(medication);
		
	}
 

    public List<MedicationDTO> getAllMedications(){
    	List<Medication> medicationList = medicationRepo.findAll();
    	return modelMapper.map(medicationList,new TypeToken<List<MedicationDTO>>() {}.getType());
    }
    
    public MedicationDTO updateMedication(MedicationDTO medicationDTO) {
    	medicationRepo.save(modelMapper.map(medicationDTO, Medication.class));
    	return medicationDTO;
    }

    
    public MedicationDTO deleteMedication(MedicationDTO medicationDTO) {
    	medicationRepo.delete(modelMapper.map(medicationDTO, Medication.class));
    	return medicationDTO;
    }


}
