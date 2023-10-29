package com.task.a.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.task.a.DTO.DroneDTO;
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
   /* public MedicationLoadRequest loadMedication(MedicationLoadRequest request) {
        try {
            Drone drone = modelMapper.map(request.getDrone(), Drone.class);
            //Medication medication = modelMapper.map(request.getMedication(), Medication.class);

            // Save the Drone and Medication details
            droneRepo.save(drone);
            //medication.setDrone(drone); // Associate Medication with the Drone
            //medicationRepo.save(medication);
        } catch (Exception e) {
            e.printStackTrace();
            // You should handle exceptions and possibly return an error response here.
            return null;
        }
        return request;
    }
	public MedicationLoadRequest loadmedication(MedicationLoadRequest medicationLoadRequest) {
        try {
            Medication d = modelMapper.map(medicationLoadRequest,Medication.class);
            
            medicationRepo.save(d);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicationLoadRequest;

	}*/

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



    
    
    //check this, this funtion need
   /* public MedicationDTO getMedicationByCode(String code) {
    	Medication medication = medicationRepo.getMedicationByCode(code);
  	  	return modelMapper.map(medication,MedicationDTO.class );
    }*/
    

}
