type UserInputProps = {
    userInput: string;
    setUserInput: any;
  };

const Search = ( props: UserInputProps ) => {
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
        
    </>
  );
}

export default Search;
