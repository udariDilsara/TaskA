import axios from 'axios';


const DRONE_API_BASE_UI = "http://localhost:8085/api/v1/drone/get_drones";
const DRONE_API_BASE_UI_POST = "http://localhost:8085/api/v1/drone/save_drones";

class DroneService{
    
    getDrones(){
        return axios.get(DRONE_API_BASE_UI);
    }

    addDrone(drone){
        return axios.post(DRONE_API_BASE_UI_POST, drone);
    }
}

const instance = new DroneService(); // Create an instance of the class

export default instance;