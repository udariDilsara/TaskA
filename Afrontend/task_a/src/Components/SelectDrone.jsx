import axios from "axios";
import React, { useEffect,useState } from "react";
import { Link } from "react-router-dom";

const ModelEnum = {
   
  CRUSEREWEIGH: 'CRUSEREWEIGH',
  HEAVYWEIGHT: 'HEAVYWEIGHT',
  LIGHTWEIGHT: 'LIGHTWEIGHT',
  MIDDLEWEIGHT: 'MIDDLEWEIGHT',
  // Add more enum values as needed
};

export default function SelectDrone () {
    const [drone, setDrone] = useState({
        serial_number: 0,
        model:ModelEnum.CRUSEREWEIGH,
        weight_limit: 0,
      });
    
      //const { serial_number } = useParams();
      const Weight = 500; // Corrected weight assignment
      useEffect(() => {
        loadDrone(Weight);
      }, []);
    
      const loadDrone = async (Weight) => {
        const result = await axios.get(`http://localhost:8085/api/v1/drone/get_drones_by_weight_limit/${Weight}`);
        setDrone(result.data);
        console.log("Fetched Drone Object:", result.data);
      };
    
      return (
        <div className="container">
          <div className="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
              <h2 className="text-center m-4">Drone details</h2>
    
              <div className="card">
                <div className="card-header">
                  Serial Number : {drone.serial_number}
                  <ul className="list-group list-group-flush">
                    <li className="list-group-item">
                      <b>Model</b>
                      {drone.model}
                    </li>
                    <li className="list-group-item">
                      <b>Weight limit</b>
                      {drone.weight_limit}
                    </li>
                  </ul>
                </div>
              </div>
              <Link className="btn btn-primary my-2" to={"/"}>
                Back to Home
              </Link>
            </div>
          </div>
        </div>
      );
}

;