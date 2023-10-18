import { useEffect, useState } from 'react';
import Search from './Search';
import axios from 'axios';

const Gallery = () => {
  const [searchResults, setSearchResults] = useState<string[]>([]);
  const [randomResult, setRandomResult] = useState<string[]>([]);

  const [userInput, setUserInput] = useState('');
  const localBaseURL = `http://localhost:8080/api/cocktails/${userInput}`;
  const localRandomURL = 'http://localhost:8080/api/cocktails/random';
  // const DB_URL = `http://www.thecocktaildb.com/api/json/v1/1/search.php?s=${userInput}`
  // const DB_RANDOM_URL = "http://www.thecocktaildb.com/api/json/v1/1/random.php"

  useEffect(() => {
    const searchCocktail = async () => {
      try {
        if (userInput) {
          const response = await axios.get(localBaseURL);
          setSearchResults(response.data);
          console.log(searchResults);
        }
        const randomReponse = await axios.get(localRandomURL);
        setRandomResult(randomReponse.data);
        console.log(randomResult);
      } catch (error) {
        console.log(error);
      }
    };
    searchCocktail();

    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [localBaseURL]);

  return (
    <section className="gallery">
      <Search userInput={userInput} setUserInput={setUserInput} searchResults={searchResults} randomResult={randomResult}/>
    </section>
  );
};

export default Gallery;
