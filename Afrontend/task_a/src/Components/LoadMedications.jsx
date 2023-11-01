import React, { useState } from "react";
import { loadMedications } from "../dummydata"; 
import axios from "axios";
//import { useNavigate } from 'react-router-dom';

const ModelEnum = {
   
  CRUSEREWEIGH: 'CRUSEREWEIGH',
  HEAVYWEIGHT: 'HEAVYWEIGHT',
  LIGHTWEIGHT: 'LIGHTWEIGHT',
  MIDDLEWEIGHT: 'MIDDLEWEIGHT',
  // Add more enum values as needed
};
export default function LoadMedications() {
  //let navigate =useNavigate();
  const [selectedMedication, setSelectedMedication] = useState(null);
  const [selectedDrone, setSelectedDrone] = useState(
    {serial_number: 0,
    model:ModelEnum.CRUSEREWEIGH,
    weight_limit: 0,
  });

  const [loadedData, setLoadedData] = useState(null);


  const handleMedicationSelect = (medication) => {
    setSelectedMedication(medication);
    console.log(medication);
    handleSelectDrone ();
    console.log(selectedDrone.serial_number);
  };
  const handleSelectDrone = async () => {
    if (selectedMedication) {
      const medicationWeight = selectedMedication.weight;
      console.log(medicationWeight);

      try {
        const response = await axios.get(`http://localhost:8085/api/v1/drone/get_drones_by_weight_limit/${medicationWeight}`);
        console.log(response.data);
        const droneData = response.data; 
        console.log(droneData);
        if (droneData && droneData.length > 0) {
          //const firstDrone = droneData[0]; // Access the first element
          for (const drone of droneData) {
          if (drone.serial_number) {
            console.log(drone.serial_number);
            setSelectedDrone(drone);
            break;
          } else {
            console.error("Drone data is missing serial_number property.");
          }
        }
        }  
      } catch (error) {
        // Handle any potential errors, such as network issues or API errors
        console.error("Error fetching drone data:", error);
      }
    }
  };
  

  const handleLoad = async () => {
    if (selectedMedication && selectedDrone) {
      const dataToSend = {
        code: selectedMedication.code,
        name: selectedMedication.name,
        weight: selectedMedication.weight,
        serial_number: selectedDrone.serial_number,
      };
        console.log(dataToSend);
      try {
        const response = await axios.post("http://localhost:8085/api/v1/medication/load", dataToSend);
        //navigate("/");
        setLoadedData(response.data);
      } catch (error) {
        console.error("Error loading medication:", error);
      }
    }
  };

  return (
    <div className="container" style={{ backgroundImage: `url(../drone.jpg)`,  backgroundSize: 'cover',
    backgroundRepeat: 'no-repeat',
    backgroundPosition: 'center', }}>
      
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">S.N</th>
              <th scope="col">Code</th>
              <th scope="col">Name</th>
              <th scope="col">Weight</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            {loadMedications.map((medication, index) => (
              <tr key={index}>
                <td>{index + 1}</td>
                <td >{medication.code}</td>
                <td >{medication.name}</td>
                <td >{medication.weight}</td>
                <td>
                  <input
                    type="radio"
                    name="selectedMedication"
                    value={medication.name}
                    onChange={() => handleMedicationSelect(medication)}
                  />
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        <div class="container overflow-hidden">
          <div class="container" >
            <div class="row align-items-center" >
              <div class=" col p-3 border bg-light">
                <div><p >Selected Medication: {selectedMedication ? selectedMedication.name : "None selected"}</p></div>
                <div class="row justify-content-around">
                < div class="col" ><p >Drone Serial Number: {selectedDrone ? selectedDrone.serial_number : "None selected"}</p></div>
                  <div class="col" ><button onClick={handleSelectDrone} class="btn btn-outline-primary ">Select Drone</button></div>  
                </div>
                </div>
              </div> 
            </div>
          </div> 
          <div class="container" >
            <div class="row align-items-center" >
              <div >
                <div class="row justify-content-around" >  
                <button onClick={handleLoad} class="btn btn btn-success"  >Load</button>
              </div>
            </div>  
        </div>
        <div>
            {loadedData && <p>Data Loaded: {JSON.stringify(loadedData)}</p>}
        </div>
      </div>
    </div>
  </div>
  );
}
