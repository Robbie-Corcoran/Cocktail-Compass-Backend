package com.example.cocktailcompass.cocktail.sevices;

import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import com.example.cocktailcompass.cocktail.exceptions.FavouriteCocktailServiceException;

public interface FavouriteCocktailService {

    CocktailDTO saveFavouriteCocktail(CocktailDTO cocktailDTO) throws FavouriteCocktailServiceException;
}
