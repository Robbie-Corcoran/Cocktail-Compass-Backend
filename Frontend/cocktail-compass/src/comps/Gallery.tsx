import { useEffect, useState } from 'react';
import Search from './Search'
import axios from 'axios';



const Gallery = () => {
  const [searchResults, setSearchResults] = useState<string[]>([]);
  const [userInput, setUserInput] = useState('');
  const baseURL = `http://localhost:8080/api/cocktails/${userInput}`;


  useEffect(() => {
    const getCocktail = async () => {
      try {
        if (userInput) {
        const response = await axios.get(`${baseURL}`);
        setSearchResults(response.data);
        console.log(searchResults);
        }
      } catch (error) {
        console.log(error);
      }
    };
    getCocktail();
  }, [baseURL, userInput]);
  // Check the dependencies above.


  return (
    <Search 
        userInput={userInput} 
        setUserInput={setUserInput} 
        />
  )
}

export default Gallery