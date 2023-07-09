import { Link } from 'react-router-dom';


const Navbar = () => {

  return (
    <nav className='navbar'> 
        <Link className='navbar__item' to="/">Home </Link>| 
        <Link className='navbar__item' to="https://github.com/Robbie-Corcoran/Cocktail-Compass" target="_blank"> GitHub </Link>|
        <Link className='navbar__item' to="/about"> About</Link> |
        <Link className='navbar__item' to="/favourites"> Favourites</Link> 
    </nav>
  )
}

export default Navbar