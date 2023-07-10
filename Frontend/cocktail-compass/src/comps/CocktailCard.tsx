import axios from 'axios';
import { useState } from 'react';

// eslint-disable-next-line @typescript-eslint/no-explicit-any
const CocktailCard = ({ cocktail }: { cocktail: any }) => {
  interface Ingredient {
    measure: string;
    ingredient: string;
  }

  const cocktailName: string = cocktail.strDrink;
  const cocktailThumbnail: string = cocktail.strDrinkThumb;
  const cocktailGlass: string = cocktail.strGlass;
  const cocktailInstructions: string = cocktail.strInstructions;
  const cocktailIngredients: Ingredient[] = [];
  const [isFavourite, setIsFavourite] = useState(false);

  const toggleFavourite = async () => {
    setIsFavourite(!isFavourite);
    const favouriteURL = 'http://localhost:8080/api/cocktails/favourites';
    const data =  
    {
      "idDrink": cocktail.idDrink,
      "strDrink": cocktail.strDrink,
      "strIBA": cocktail.strIBA,
      "strGlass": cocktail.strGlass,
      "strInstructions": cocktail.strInstructions,
      "strDrinkThumb": cocktail.strDrinkThumb,
      "strIngredient1": cocktail.strIngredient1,
      "strIngredient2": cocktail.strIngredient2,
      "strIngredient3": cocktail.strIngredient3,
      "strIngredient4": cocktail.strIngredient4,
      "strIngredient5": cocktail.strIngredient5,
      "strIngredient6": cocktail.strIngredient6,
      "strIngredient7": cocktail.strIngredient7,
      "strIngredient8": cocktail.strIngredient8,
      "strIngredient9": cocktail.strIngredient9,
      "strIngredient10": cocktail.strIngredient10,
      "strIngredient11": cocktail.strIngredient11,
      "strIngredient12": cocktail.strIngredient12,
      "strIngredient13": cocktail.strIngredient13,
      "strIngredient14": cocktail.strIngredient14,
      "strIngredient15": cocktail.strIngredient15,
      "strMeasure1": cocktail.strMeasure1,
      "strMeasure2": cocktail.strMeasure2,
      "strMeasure3": cocktail.strMeasure3,
      "strMeasure4": cocktail.strMeasure4,
      "strMeasure5": cocktail.strMeasure5,
      "strMeasure6": cocktail.strMeasure6,
      "strMeasure7": cocktail.strMeasure7,
      "strMeasure8": cocktail.strMeasure8,
      "strMeasure9": cocktail.strMeasure9,
      "strMeasure10": cocktail.strMeasure10,
      "strMeasure11": cocktail.strMeasure11,
      "strMeasure12": cocktail.strMeasure12,
      "strMeasure13": cocktail.strMeasure13,
      "strMeasure14": cocktail.strMeasure14,
      "strMeasure15": cocktail.strMeasure15
    }
    try {
      if (isFavourite) {
        await axios.delete(`${favouriteURL}/${cocktail.idDrink}`);
        setIsFavourite(!isFavourite);
        console.log('Cocktail removed from favorites');
      } else {
        await axios.post(favouriteURL, data);
        setIsFavourite(isFavourite);
        console.log('Cocktail added to favorites');
      }
    } catch (error) {
      console.log(error);
    }

  };

  const ingredientList = () => {
    for (let i = 1; i <= 15; i++) {
      const ingredient = cocktail[`strIngredient${i}`];
      const measure = cocktail[`strMeasure${i}`];
      if (ingredient && measure) {
        cocktailIngredients.push({ ingredient, measure });
      }
    }
  };

  ingredientList();

  return (
    <>
      <article className="cocktail-card">
        <img className="cocktail-card__image" src={cocktailThumbnail} height={100} alt={cocktailName} />
        <h2>{cocktailName}</h2>
        <h4>{cocktailGlass}</h4>
        <p>
          {cocktailIngredients.map((ingredient, index) => (
            <span key={index}>
              {ingredient.ingredient}: {ingredient.measure}
              {index !== cocktailIngredients.length - 1}
              <br></br>
            </span>
          ))}
        </p>
        <p className="cocktail-card__instructions">{cocktailInstructions}</p>
        <button onClick={toggleFavourite}>{isFavourite ? 'Remove Favourite' : 'Add Favourite'}</button>
      </article>
    </>
  );
};

export default CocktailCard;
