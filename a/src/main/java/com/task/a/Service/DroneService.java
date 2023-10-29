package com.task.a.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.a.DTO.DroneDTO;
import com.task.a.Entity.Drone;
import com.task.a.Model.DroneModel;
import com.task.a.Repository.DroneRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DroneService {
	
	@Autowired
	private DroneRepo droneRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/*public DroneDTO savedrone(DroneDTO droneDTO) {
		droneRepo.save(modelMapper.map(droneDTO, Drone.class));
		return droneDTO;
	}*/
	
	/*public DroneDTO savedrone(DroneDTO droneDTO) {
	    // Check if a drone with the same serial_number already exists
	    int serialNumber = droneDTO.getSerial_number();
	    Drone existingDrone = droneRepo.findById(serialNumber).orElse(null);

	    if (existingDrone != null) {
	        // A drone with the same serial_number already exists, handle the situation
	        // You can return an error, update the existing record, or perform any other necessary action
	        // For this example, let's update the existing record with the new data
	        existingDrone.setModel(droneDTO.getModel());
	        existingDrone.setWeight_limit(droneDTO.getWeight_limit());
	        droneRepo.save(existingDrone);
	        return modelMapper.map(existingDrone, DroneDTO.class);
	    } else {
	        // Create a new Drone entity with the provided serial_number
	        Drone newDrone = modelMapper.map(droneDTO, Drone.class);
	        droneRepo.save(newDrone);
	        return modelMapper.map(newDrone, DroneDTO.class);
	    }
	}*/
	

	public DroneDTO savedrone(DroneDTO droneDTO) {
        try {
            Drone d = modelMapper.map(droneDTO,Drone.class);
            
            droneRepo.save(d);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return droneDTO;
	}

    
    public List<DroneDTO> getAllDrones(){
    	List<Drone> droneList = droneRepo.findAll();
    	return modelMapper.map(droneList,new TypeToken<List<DroneDTO>>() {}.getType());
    }
    
    public DroneDTO updateDrone(DroneDTO droneDTO) {
    	droneRepo.save(modelMapper.map(droneDTO, Drone.class));
    	return droneDTO;
    }
    
    public DroneDTO deleteDrone(DroneDTO droneDTO) {
    	droneRepo.delete(modelMapper.map(droneDTO, Drone.class));
    	return droneDTO;
    }
    
  public DroneDTO getDroneBySerialNumber(Integer serial_number) {
	  Drone drone = droneRepo.getDroneByDroneSerialNUmber(serial_number);
	  return modelMapper.map(drone,DroneDTO.class );
  }
  
  public List<DroneDTO> getDroneByWeightLimit(Double weight_limit) {
	  List<Drone> drone = droneRepo.getDroneByWeightLimit(weight_limit);
	  return modelMapper.map(drone,new TypeToken<List<DroneDTO>>() {}.getType() );
  }


	public DroneDTO deleteDroneBySerialNumber(Integer serial_number) {
		  Drone drone = droneRepo.getDroneByDroneSerialNUmber(serial_number);
		  droneRepo.delete(drone);
		  return modelMapper.map(drone,DroneDTO.class );
	}

	//return serial_number of one drone
	public int getDroneSerialNumberByWeightLimit(Double weight_limit) {
		Drone drone = droneRepo.getOneDroneByWeightLimit(weight_limit);
		return drone.getSerial_number();
	}
    
}

