import './App.css'
import {useEffect, useState} from "react";
import axios from "axios";

function App() {

  const baseURL = "http://localhost:8080/hello";
  const [greeting, setGreeting] = useState('');

  useEffect(() => {
    const getGreeting = async () => {
      try {
        const response = await axios.get(baseURL);
        setGreeting(response.data);
      } catch (error){
        console.log(error);
      }
    }
    getGreeting();
  }, [])
  return (
    <>
      <h1>{greeting}</h1>
    </>
  )
}

export default App
