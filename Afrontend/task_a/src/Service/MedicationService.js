import axios from 'axios';


const MEDICATION_API_BASE_UI = "http://localhost:8085/api/v1/medication/get_medications";

class MedicationService{
    
    getMedications(){
        return axios.get(MEDICATION_API_BASE_UI);
    }
}



const instance = new MedicationService(); // Create an instance of the class

export default instance;