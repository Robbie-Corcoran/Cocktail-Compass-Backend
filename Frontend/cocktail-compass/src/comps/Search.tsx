import CocktailCard from './CocktailCard';
import RandomCocktail from './RandomCocktail';

type UserInputProps = {
  userInput: string;
  setUserInput: (args: string) => void;
  searchResults: string[];
  randomResult: string[];
};

const Search = (props: UserInputProps) => {
  const results = props.searchResults.map((obj, i) => {
    return (
      <section className="result">
        <CocktailCard cocktail={obj} key={i} />
      </section>
    );
  });

  const onClearHandler = () => props.setUserInput("");

  return (
    <>
      <form name="searchCocktail" role="search">
        <input
          id=''
          className='search__input'
          name="search"
          type="text"
          placeholder="WHAT WILL IT BE?"
          value={props.userInput}
          onChange={(event) => {
            props.setUserInput(event.currentTarget.value);
          }}
        />
      </form>
      <button className='button' type="button" onClick={onClearHandler}>CLEAR SEARCH</button>
      <RandomCocktail randomResult={props.randomResult} />
      <section className='result'>{results}</section>
    </>
  );
};

export default Search;
