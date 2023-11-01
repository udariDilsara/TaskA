import axios from 'axios';


const MEDICATION_API_BASE_UI = "http://localhost:8085/api/v1/medication/get_medications";
const MEDICATION_API_BASE_UI_GET_DRONE = "http://localhost:8085/api/v1/drone/get_SerialNumber_by_weight_limit/{$weight_limit}";

class MedicationService{
    
    getMedications(){
        return axios.get(MEDICATION_API_BASE_UI);
    }

    getSelectedDrone(weight_limit){
        return axios.get(MEDICATION_API_BASE_UI_GET_DRONE,weight_limit);
    }

    addDrone(weightLimit) {
        return axios.post(MEDICATION_API_BASE_UI_GET_DRONE.replace('{weight_limit}', weightLimit))
          .then((response) => {
            return response.data.serialNumber; // Assuming your API response contains the serial number.
          });
      }
}



const instance = new MedicationService(); 

export default instance;