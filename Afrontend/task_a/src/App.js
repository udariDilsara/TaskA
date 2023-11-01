//import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route,  Routes } from 'react-router-dom';
import Home from './Components/Home';
import Drone from './Components/Drone';
//import LoadMedication from './Components/LoadMedication.jsx';
import AvailableDrone from './Components/AvailableDrone';
import NavBar from './Components/NavBar';
import Footer from './Components/Footer';
import AddDrones from './Components/AddDrones';
import LoadMedications from './Components/LoadMedications';
//import SelectDrone from './Components/SelectDrone';
import MedicationTable from './Components/MedicationTable';
function App() {
  return (
    <>
    <Router>

      <div className='container'> 
          <NavBar/>
          <div className='container'>
              <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/drone" element={<Drone />} />
                
                <Route path="/loadmedications" element={<LoadMedications />} />
                <Route exact path="/addrones" element={<AddDrones />} />
                <Route exact path="/medicationtable" element={<MedicationTable/>} />
                <Route path="/availabledrone" element={<AvailableDrone />} />
              </Routes>
          </div>
          <Footer/>
      </div>
    </Router>
    </>
  );
}

export default App;
