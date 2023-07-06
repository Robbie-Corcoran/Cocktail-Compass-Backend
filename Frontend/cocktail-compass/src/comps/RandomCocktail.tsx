import { useState } from 'react';
import CocktailCard from './CocktailCard';

type RandomProps = {
  randomResult: string[];
};

const RandomCocktail = (props: RandomProps) => {
    const [result, setResult] = useState<JSX.Element[]>([]);
  
    const handleRandomCocktail = () => {
      const randomCocktails = props.randomResult.map((obj, i) => (
        <section className="random-results" key={i}>
          <CocktailCard cocktail={obj} />
        </section>
      ));
  
      setResult(randomCocktails);
    };

  return (
    <>
      <button className='random-button' onClick={handleRandomCocktail}>RANDOM COCKTAIL</button>
      {result}
    </>
  );
};

export default RandomCocktail;
