import CocktailCard from './CocktailCard';
import RandomCocktail from './RandomCocktail';

type UserInputProps = {
  userInput: string;
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  setUserInput: any;
  searchResults: string[];
  randomResult: string[];
};

const Search = (props: UserInputProps) => {
  const results = props.searchResults.map((obj, i) => {
    return (
      <section className="search-results">
        <CocktailCard cocktail={obj} key={i} />
      </section>
    );
  });

  return (
    <>
      <form name="searchCocktail" role="search">
        <input
          id="search"
          type="search"
          placeholder="What are we making tonight?"
          value={props.userInput}
          onChange={(event) => {
            props.setUserInput(event.currentTarget.value);
          }}
        />
      </form>
      <RandomCocktail randomResult={props.randomResult} />
      <section>{results}</section>
    </>
  );
};

export default Search;
