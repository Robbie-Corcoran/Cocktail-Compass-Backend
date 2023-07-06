const CocktailCard = ({cocktail}) => {
  interface Ingredient {
    measure: string;
    ingredient: string;
  }

  const cocktailName = cocktail.strDrink;
  const cocktailThumbnail = cocktail.strDrinkThumb;
  const cocktailGlass = cocktail.strGlass;
  const cocktailInstructions = cocktail.strInstructions;
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
      <article>
        <img src={cocktailThumbnail} height={100} alt={cocktailName} />
        <h2>{cocktailName}</h2>
        <h4>{cocktailGlass}</h4>
        <p>{cocktailIngredients.map((ingredient, index) => (
              <span key={index}>
                {ingredient.ingredient}: {ingredient.measure}
                {index !== cocktailIngredients.length - 1 && ", "}
              </span> 
              ))}
        </p>
        <p>{cocktailInstructions}</p>
      </article>
    </>
  )
};

export default CocktailCard;
