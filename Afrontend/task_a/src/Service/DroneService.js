import axios from 'axios';


const DRONE_API_BASE_UI = "http://localhost:8085/api/v1/drone/get_drones";

class DroneService{
    
    getDrones(){
        return axios.get(DRONE_API_BASE_UI);
    }


}

const instance = new DroneService();

export default instance;