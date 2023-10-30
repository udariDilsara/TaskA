import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Home extends Component {
    render() {
        return (
            
            
            <div className="container mt-5 ">


            <div className="row">
            <div className="d-flex align-items-center justify-content-center" style={{ height: "10vh" }}>
                <div className="card w-50">
                    <div className="card-body">
                    <h3 className="card-title text-center">Drone</h3>
                    <Link to="/drone">
                        <button type="button" className="btn btn-outline-primary">more</button>
                    </Link>
                    {/* Add content for Drone box */}
                    </div>
                </div>
            </div>
              <div className="d-flex align-items-center justify-content-center" style={{ height: "50vh" }}>
                <div className="card w-50 ">
                  <div className="card-body ">
                  <h3 class="card-title text-center">Load Medication</h3>
                    <Link to="/loadmedication"><button type="button" class="btn btn-outline-primary ">more</button></Link>
                    {/* Add content for Load Medication box */}
                  </div>
                </div>
              </div>
            </div>
          </div>
        );
    }
}

export default Home;