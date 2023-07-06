import { Link } from 'react-router-dom';


const Navbar = () => {

  return (
    <nav> 
        <Link to="/"> Home</Link> | 
        <Link to="/about"> About</Link> |
        <Link to="https://github.com/Robbie-Corcoran/Cocktail-Compass"> GitHub</Link>
    </nav>
  )
}

export default Navbar