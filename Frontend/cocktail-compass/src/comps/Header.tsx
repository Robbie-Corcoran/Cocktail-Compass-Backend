import Navbar from './Navbar'

const Header = () => {
  return (
    <>
    <section className='header'>
      <Navbar />
      <h2>C O C K T A I L<br/>
        C O M P A S S</h2>
      <img className='logo' src="./src/assets/Logo-white.png" height={250}  alt="Cocktail Compass Logo" />
    </section>
    </>
  )
}

export default Header