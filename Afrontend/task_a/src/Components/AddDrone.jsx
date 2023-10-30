import React, { Component } from 'react';
import DroneService from '../Service/DroneService';

class AddDrone extends Component {
    constructor(props){
        super(props)

        this.state = {
            serial_number: '',
            model: ModelEnum.DEFAULT,
            weight_limit: '',

        }
    }
    saveDrone = (e) =>{
        e.preventDefault();
        let drone = {serial_number :parseInt(this.state.serial_number,10),model : this.state.model, weight_limit : parseInt(this.state.weight_limit,10) };
        console.log('drone =>' + JSON.stringify(drone));

        DroneService.addDrone(drone).then(res =>{
            this.props.history.push('/drone');
        });
    }
    cancel (){
        
        this.props.history.push('/drone');
    }
    handleModelChange = (event) => {
        const selectedModel = event.target.value;
        this.setState({ model : selectedModel });
      };

    changeSerialNumberHandler =(event) => {
        this.setState({serial_number: event.target.value});
    }
    changeWeightLimitNumberHandler =(event) => {
        this.setState({weight_limit: event.target.value});
    }
    render() {
        return (
            <div>
                <div className='container'>
                    <div className='row'>
                        <div className='card col-md-6 offset-md-3 offset-md-3'>
                            <h3 className='text-center'>Add Drone</h3>
                            <div className='card-body'>
                                <form>
                                    <div className='form-group'>
                                        <label> Serial Number:</label>
                                        <input placeholder='Serial Number' name='serialnumber' className='form-control' 
                                        value={this.state.serial_number} onChange={this.changeSerialNumberHandler} />
                                        <label> Model:</label>
                                        <select
                                            className="form-select" // Fixed: should be className, not class
                                            value={this.state.model}
                                            onChange={this.handleModelChange}
                                        >
                                            <option value={ModelEnum.DEFAULT}>Select a Model</option>
                                            <option value={ModelEnum.CRUSEREWEIGH}>{ModelEnum.CRUSEREWEIGH}</option>
                                            <option value={ModelEnum.HEAVYWEIGHT}>{ModelEnum.HEAVYWEIGHT}</option>
                                            <option value={ModelEnum.LIGHTWEIGHT}>{ModelEnum.LIGHTWEIGHT}</option>
                                            <option value={ModelEnum.MIDDLEWEIGHT}>{ModelEnum.MIDDLEWEIGHT}</option>
                                            {/* Add more enum values as needed */}
                                        </select>
                                            <p>Selected Model: {this.state.model}</p>
                                        <label> Weight Limit:</label>
                                        <input placeholder='Weight Limit' name='weightlimit' className='form-control' 
                                        value={this.state.weight_limit} onChange={this.changeWeightLimitNumberHandler} />
                                    </div>
                                    <button className='btn btn-success' onClick={this.saveDrone}>Save</button>
                                    <button className='btn btn-danger' onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

const ModelEnum = {
    DEFAULT: 'Default',
    CRUSEREWEIGH: 'Cruser Weight',
    HEAVYWEIGHT: 'Heavy Weight',
    LIGHTWEIGHT: 'Light Weight',
    MIDDLEWEIGHT: 'Middle Weight',
    // Add more enum values as needed
  };


export default AddDrone;