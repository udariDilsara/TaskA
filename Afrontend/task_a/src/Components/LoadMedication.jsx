import React, { Component } from 'react';
import MedicationService from '../Service/MedicationService';
class LoadMedication extends Component {
    constructor(props){
        super(props)

        this.state = {
                medications : []
        }
    }
    componentDidMount(){
        MedicationService.getMedications().then((res) => {
            this.setState({medications: res.data});
        }

        )
    }
    render() {
        return (
            <div className='container mt-5'>
               <h1 className='text-center'>Load Medications</h1>
               <div className='row'>
                    <table className='table table-striped- table-bordered'>
                        <thead>
                            <tr>
                                <th>Code</th>
                                <th>Name</th>
                                <th>Weight limit</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.medications.map(
                                    medication =>
                                    <tr key = {medication.code}>
                                            <td>{medication.code}</td>
                                            <td>{medication.name}</td>
                                            <td>{medication.weight}</td>
                                            <th><input class="form-check-input" type="radio" name="medicationRadio" value={medication.code}/></th>
                                           
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
               </div>
               <h4>Selected drone : <button type="button" className="btn btn-outline-primary">Auto selected drone</button></h4>
               <button type="button" className="btn btn-outline-primary">Add</button>
            </div>
        );
    }
}

export default LoadMedication;