import { useState } from 'react';
import CocktailCard from './CocktailCard';

type FavouriteProps = {
  favouriteResult: string[];
};

const Favourites = (props: FavouriteProps) => {
  const [result, setResult] = useState<JSX.Element[]>([]);

  const getFavouriteCocktails = () => {
    const favouriteCocktails = props.favouriteResult.map((obj, i) => (
      <section>
        <CocktailCard cocktail={obj} key={i} />
      </section>
    ));

    setResult(favouriteCocktails);
  };

  return (
    <>
      <button className="button" onClick={getFavouriteCocktails}>
        FAVOURITES
      </button>
      <section className="result">{result}</section>
    </>
  );
};

export default Favourites;
