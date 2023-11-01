import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';

const ModelEnum = {
   
    CRUSEREWEIGH: 'CRUSEREWEIGH',
    HEAVYWEIGHT: 'HEAVYWEIGHT',
    LIGHTWEIGHT: 'LIGHTWEIGHT',
    MIDDLEWEIGHT: 'MIDDLEWEIGHT',
    // Add more enum values as needed
  };

 export default function AddDrones() {
    let navigate =useNavigate();
    const [drone, setDrone] = useState(
        {
            serial_number: '',
            model: ModelEnum.DEFAULT,
            weight_limit: '',
        }
    );
    const {serial_number, model , weight_limit} = drone;
    const onInputChange = (e) => {
        setDrone({...drone, [e.target.name]: e.target.value});
    };
     const onSubmit = async (e) =>{
        e.preventDefault();
        await axios.post("http://localhost:8085/api/v1/drone/save_drones",drone);
        navigate("/drone");
     }

        
    return (
        <div>
            <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Register Drone</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Serial Number" className="form-label">
                Serial Number
              </label>
              <input
                type={"number"}
                className="form-control"
                placeholder="Enter Drone Serial Number(Only Numbers)"
                name="serial_number"
                value={serial_number}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Model" className="form-label">
                Model
              </label>
              <select
                    className="form-select"
                    value={model}
                     onChange={(e) => onInputChange(e)}
                    name="model"
                ><option >Select Model</option>
                <option value={ModelEnum.CRUSEREWEIGHT}>CRUSEREWEIGHT</option>
                <option value={ModelEnum.HEAVYWEIGHT}>HEAVYWEIGHT</option>
                <option value={ModelEnum.LIGHTWEIGHT}>LIGHTWEIGHT</option>
                <option value={ModelEnum.MIDDLEWEIGHT}>MIDDLEWEIGHT</option>
                </select>
            </div>
            <div className="mb-3">
              <label htmlFor="Weight Limit" className="form-label">
                Weight Limit
              </label>
              <input
                type={"number"}
                className="form-control"
                placeholder="Enter weight limit(Only Numbers)"
                name="weight_limit"
                value={weight_limit}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <button type="submit" className="btn btn-outline-primary">
              Submit
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/drone">
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
        </div>
    );
}
