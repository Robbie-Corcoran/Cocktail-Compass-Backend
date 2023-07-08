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
      </article>
    </>
  );
};

export default CocktailCard;
