import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';



 export default function AddDrones() {
    let navigate =useNavigate();
    const [medication, setDrone] = useState(
        {
            code: 0,
            name: '',
            weight: 0,
        }
    );
    const {code, name,weight} = medication;
    const onInputChange = (e) => {
        setDrone({...medication, [e.target.name]: e.target.value});
    };
     const onSubmit = async (e) =>{
        e.preventDefault();
        await axios.post("http://localhost:8085/api/v1/medication/load_medication?serial_number=3",medication);
        console.log(medication);
        navigate("/");
     }

        
    return (
        <div>
            <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Medication</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Serial Number" className="form-label">
                Code
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter Drone Serial Number(Only Numbers)"
                name="code"
                value={code}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Model" className="form-label">
                Medication Name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter Medication Name"
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Weight Limit" className="form-label">
                Weight 
              </label>
              <input
                type={"number"}
                className="form-control"
                placeholder="Enter weight (Only Numbers)"
                name="weight"
                value={weight}
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
