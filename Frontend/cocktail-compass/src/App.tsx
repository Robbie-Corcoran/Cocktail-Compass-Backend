import './App.css';
import { Routes, Route } from 'react-router-dom';
import Header from './comps/Header';
import About from './comps/About';
import Gallery from './comps/Gallery';

function App() {
  return (
    <>
      <Header />
      <Routes>
        <Route path="/" element={<Gallery />}></Route>
        <Route path="/about" element={<About />}></Route>
      </Routes>
    </>
  );
}

export default App;
