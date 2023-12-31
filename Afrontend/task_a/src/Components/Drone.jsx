import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Drone extends Component {

    render() {

        return (
<div className="container  " style={{ backgroundImage: `url(../drone.jpg)`,  backgroundSize: 'cover',
  backgroundRepeat: 'no-repeat',
  backgroundPosition: 'center',opacity: 1.7}}>


<div className="row">
    <div className="d-flex align-items-center justify-content-center" style={{ height: "40vh" }}>
        <div className="card w-50">
            <div className="card-body d-flex align-items-center justify-content-center">
            
            <Link to="/addrones">
            <   button type="button" className="btn btn-outline-primary" >Add Drone</button>
            </Link>
            
            </div>
        </div>
    </div>
    <div className="d-flex align-items-center justify-content-center" style={{ height: "43vh" }}>
        <div className="card w-50 ">
        <div className="card-body d-flex align-items-center justify-content-center">
        
            <Link to="/availabledrone">
                <button type="button" class="btn btn-outline-primary ">Available Drone</button>
            </Link>
        
        </div>
        </div>
    </div>
</div>
</div>
        );
    }
}

export default Drone;