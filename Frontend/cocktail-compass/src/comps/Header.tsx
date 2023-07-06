import Navbar from './Navbar'

const Header = () => {
  return (
    <>
    <section className='header'>
    <Navbar />
    <img className='logo' src="./src/assets/Logo-white.png" height={250}  alt="Cocktail Compass Logo" />
    </section>
    </>
  )
}

export default Header