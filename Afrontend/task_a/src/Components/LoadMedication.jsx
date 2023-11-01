import React, { Component } from 'react';
import MedicationService from '../Service/MedicationService';
class LoadMedication extends Component {
    constructor(props){
        super(props)

        this.state = {
                medications : [],
                serial_number : '',
                selectedMedicationCode: '',
        }
    }
    componentDidMount(){
        MedicationService.getMedications().then((res) => {
            this.setState({medications: res.data});
        }

        )
    }
    handleSelectDrone = () => {
        // Check if a medication is selected.
        if (this.state.selectedMedicationCode) {
          MedicationService.addDrone(this.state.medications.weight)
            .then((serialNumber) => {
              this.setState({ serial_number: serialNumber });
            })
            .catch((error) => {
              console.error('Error adding a drone:', error);
            });
        } else {
          alert('Please select a medication first.');
        }
      };
    handleMedicationSelect = (medicationCode) => {
        this.setState({ selectedMedicationCode: medicationCode });
      };
    
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
                                            <th>
                                            <input
                                            className="form-check-input"
                                            type="radio"
                                            name="medicationRadio"
                                            value={medication.code}
                                            onClick={() => this.handleMedicationSelect(medication.code)}
                
                                        />
                                            </th>
                                           
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
               </div>
               <h4>Selected drone : <button type="button" className="btn btn-outline-primary" value={this.state.serial_number} onClick={this.handleSelectDrone}>{this.state.serial_number}</button></h4>
               <button type="button" className="btn btn-outline-primary">Load</button>
            </div>
        );
    }
}

export default LoadMedication;