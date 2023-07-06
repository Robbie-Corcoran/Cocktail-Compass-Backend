import React from 'react'
import { useNavigate, Link } from 'react-router-dom';


const Navbar = () => {
    const navigate = useNavigate();


  return (
    <nav> 
        <Link to="/">Home</Link>
        <Link to="/about">About</Link>
        <Link to="https://github.com/Robbie-Corcoran/Cocktail-Compass">GitHub</Link>
    </nav>
  )
}

export default Navbar