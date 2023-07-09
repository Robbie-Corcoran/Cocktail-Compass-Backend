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
    setIsFavourite(true);
    const favouriteURL = 'http://localhost:8080/api/cocktails/favourites';
    try {
      const result = await axios.post(favouriteURL, {
        data: {
          id: 4,
          drinkId: cocktail.strId,
          name: cocktail.strDrink,
          // "iba": null,
          // "glass": "Martini Glass",
          // "instructions": "Add ice to a shaker and pour in all ingredients.\\nUsing a bar spoon, stir 40 to 45 revolutions or until thoroughly chilled.\\nStrain into a martini glass or over ice into a rocks glass. Garnish with orange twist.",
          // "thumbnail": "https://www.thecocktaildb.com/images/media/drink/x8lhp41513703167.jpg",
          // "strIngredient1": "Gin",
          // "strIngredient2": "Lillet",
          // "strIngredient3": "Sweet Vermouth",
          // "strIngredient4": "Orange Peel",
          // "strIngredient5": null,
          // "strIngredient6": null,
          // "strIngredient7": null,
          // "strIngredient8": null,
          // "strIngredient9": null,
          // "strIngredient10": null,
          // "strIngredient11": null,
          // "strIngredient12": null,
          // "strIngredient13": null,
          // "strIngredient14": null,
          // "strIngredient15": null,
          // "strMeasure1": "1 oz",
          // "strMeasure2": "1 oz",
          // "strMeasure3": "1 oz",
          // "strMeasure4": "1",
          // "strMeasure5": null,
          // "strMeasure6": null,
          // "strMeasure7": null,
          // "strMeasure8": null,
          // "strMeasure9": null,
          // "strMeasure10": null,
          // "strMeasure11": null,
          // "strMeasure12": null,
          // "strMeasure13": null,
          // "strMeasure14": null,
          // "strMeasure15": null
        },
      });
    } catch (error) {
      // console.log(error);
      setIsFavourite(false);
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
        <h2>{cocktailName.toUpperCase()}</h2>
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
