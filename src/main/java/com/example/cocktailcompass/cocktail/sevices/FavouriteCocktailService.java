package com.example.cocktailcompass.cocktail.sevices;

import com.example.cocktailcompass.cocktail.exceptions.favouriteCocktail.FavouriteCocktailAlreadyExistsException;
import com.example.cocktailcompass.cocktail.exceptions.favouriteCocktail.FavouriteCocktailNotFoundException;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;

import java.util.List;

public interface FavouriteCocktailService {

    CocktailDTO saveFavouriteCocktail(CocktailDTO cocktailDTO) throws FavouriteCocktailAlreadyExistsException;

    List<CocktailDTO> findAllFavouriteCocktails() throws FavouriteCocktailNotFoundException;

    void deleteFavouriteCocktail(Integer idDrink) throws FavouriteCocktailNotFoundException;

}
