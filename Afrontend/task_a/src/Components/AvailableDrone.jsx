import React, { Component } from 'react';
import DroneService from '../Service/DroneService';

class AvailableDrone extends Component {
    constructor(props){
        super(props)

        this.state = {
                drones : []
        }
    }
    componentDidMount(){
        DroneService.getDrones().then((res) => {
            this.setState({drones: res.data});
        }

        )
    }
    render() {
        return (
            <div className='container mt-5'>
               <h1 className='text-center'>Available Drone List</h1>
               <div className='row'>
                    <table className='table table-striped- table-bordered'>
                        <thead>
                            <tr>
                                <th>Drone Serial number</th>
                                <th>Model</th>
                                <th>Weight limit</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.drones.map(
                                    drone =>
                                    <tr key = {drone.id}>
                                            <td>{drone.serial_number}</td>
                                            <td>{drone.model}</td>
                                            <td>{drone.weight_limit}</td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
               </div>
            </div>
        );
    }
}

export default AvailableDrone;