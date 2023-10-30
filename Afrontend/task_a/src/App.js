//import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route,  Routes } from 'react-router-dom';
import Home from './Components/Home';
import Drone from './Components/Drone';
import LoadMedication from './Components/LoadMedication.jsx';
import AddDrone from './Components/AddDrone';
import AvailableDrone from './Components/AvailableDrone';
import NavBar from './Components/NavBar';
import Footer from './Components/Footer';
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
                <Route path="/loadmedication" element={<LoadMedication />} />
                <Route path="/addrone" element={<AddDrone />} />
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
