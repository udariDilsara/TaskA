import React, { useState } from "react";
import { loadMedications } from "../dummydata"; 
import axios from "axios";

const ModelEnum = {
   
  CRUSEREWEIGH: 'CRUSEREWEIGH',
  HEAVYWEIGHT: 'HEAVYWEIGHT',
  LIGHTWEIGHT: 'LIGHTWEIGHT',
  MIDDLEWEIGHT: 'MIDDLEWEIGHT',
  // Add more enum values as needed
};
export default function LoadMedications() {
  const [selectedMedication, setSelectedMedication] = useState(null);
  const [selectedDrone, setSelectedDrone] = useState(
    {serial_number: 0,
    model:ModelEnum.CRUSEREWEIGH,
    weight_limit: 0,
  });


  const handleMedicationSelect = (medication) => {
    setSelectedMedication(medication);
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
          const firstDrone = droneData[0]; // Access the first element
          if (firstDrone.serial_number) {
            console.log(firstDrone.serial_number);
            setSelectedDrone(firstDrone);
          } else {
            console.error("Drone data is missing serial_number property.");
          }
        }  
      } catch (error) {
        // Handle any potential errors, such as network issues or API errors
        console.error("Error fetching drone data:", error);
      }
    }
  };
  

  return (
    <div className="container">
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
        <div>
          <p>Selected Medication: {selectedMedication ? selectedMedication.name : "None selected"}</p>
        </div>
        <div><button onClick={handleSelectDrone}>Select Drone</button></div>
        <p>Selected drone: {selectedDrone ? selectedDrone.serial_number : "None selected"}</p>
        <div>
            <button  >Load</button>
        </div>
      </div>
    </div>
  );
}
