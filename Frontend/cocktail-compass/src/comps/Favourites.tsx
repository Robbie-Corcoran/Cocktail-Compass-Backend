import { useEffect, useState } from 'react';
import CocktailCard from './CocktailCard';
import axios from 'axios';

const Favourites = () => {
  const [favouriteCocktails, setFavouriteCocktails] = useState<string[]>([]);
  const favouriteURL = 'http://localhost:8080/api/cocktails/favourites';

  useEffect(() => {
    const fetchFavourites = async () => {
      try {
        const response = await axios.get(favouriteURL);
        console.log(response.data);
        setFavouriteCocktails(response.data);
        console.log(favouriteCocktails);
      } catch (error) {
        console.log(error);
      }
    };
    fetchFavourites();
  }, []);

  const results = favouriteCocktails.map((cocktail, i) => {
    // console.log(results);
    return (
      <section className="result" key={i}>
        <CocktailCard cocktail={cocktail} />
      </section>
    );
  });

  return (
    <>
      <h2 /*className="favourites__heading"*/ >FAVOURITES</h2>
      <section className="result">{results}</section>
    </>
  );
};

export default Favourites;
