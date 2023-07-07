import { useState } from 'react';
import CocktailCard from './CocktailCard';

type RandomProps = {
  randomResult: string[];
};

const RandomCocktail = (props: RandomProps) => {
  const [result, setResult] = useState<JSX.Element[]>([]);

  const handleRandomCocktail = () => {
    const randomCocktails = props.randomResult.map((obj, i) => (
      <section>
        <CocktailCard cocktail={obj} key={i} />
      </section>
    ));

    setResult(randomCocktails);
  };

  return (
    <>
      <button className="button" onClick={handleRandomCocktail}>
        RANDOM COCKTAIL
      </button>
      <section className="result">{result}</section>
    </>
  );
};

export default RandomCocktail;
