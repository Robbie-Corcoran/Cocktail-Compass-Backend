import { Link } from 'react-router-dom';


const Navbar = () => {

  return (
    <nav className='navbar'> 
        <Link to="/">Home </Link>| 
        <Link to="https://github.com/Robbie-Corcoran/Cocktail-Compass" target="_blank"> GitHub </Link>|
        <Link to="/about"> About</Link>
    </nav>
  )
}

export default Navbar