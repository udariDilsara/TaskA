import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Home extends Component {
    render() {
        return (
            
          <div className="container  "  style={{ backgroundImage: `url(../drone2.jpg)`,  backgroundSize: 'cover',
          backgroundRepeat: 'no-repeat',
          backgroundPosition: 'center',opacity: 1.7}}>
            
            <div className="row">
    <div className="d-flex align-items-center justify-content-center" style={{ height: "40vh" }}>
        <div className="card w-50">
            <div className="card-body d-flex align-items-center justify-content-center">
            
            <h1 >Welcom</h1>
            
            </div>
        </div>
    </div>
    <div className="d-flex align-items-center justify-content-center" style={{ height: "43vh" }}>
        <div className="card w-50 ">
        <div className="card-body d-flex align-items-center justify-content-center">
        
            <h3>Deliver via Drones</h3>
        
        </div>
        </div>
    </div>
</div>
          </div>
        )
    }
}

export default Home;