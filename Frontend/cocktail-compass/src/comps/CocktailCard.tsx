const CocktailCard = ({cocktail}) => {

  const cocktailName = cocktail.strDrink;
  const cocktailThumbnail = cocktail.strDrinkThumb;
  const cocktailGlass = cocktail.strGlass;
  const cocktailInstructions = cocktail.strInstructions;
  
  return <>
    <article>
      <img src={cocktailThumbnail} height={100} alt={cocktailName} />
      <h2>{cocktailName}</h2>
      <h4>{cocktailGlass}</h4>
      <p>{cocktailInstructions}</p>
    </article>
  </>;
};

export default CocktailCard;
