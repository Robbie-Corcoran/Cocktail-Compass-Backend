import CocktailCard from "./CocktailCard";


type UserInputProps = {
    userInput: string;
    setUserInput: any;
    searchResults: string[];
  };

const Search = ( props: UserInputProps ) => {
    const searchMessage = `Showing results for: ${props.userInput}`

    const results = props.searchResults.map((obj, i) => {
        return (
            <CocktailCard cocktail={obj} key={i}/>
        )
    })

  return (
    <>
        <form role="search">
        <input 
            type="search" 
            placeholder="What are we making tonight?"
            value={props.userInput}
            onChange={event => {props.setUserInput(event.currentTarget.value) && console.log(props.userInput)}}
            />
        </form>
        <h3>{searchMessage}</h3>

        {results}
        
    </>
  );
}

export default Search;
