package com.example.cocktailcompass.cocktail.sevices;

import com.example.cocktailcompass.cocktail.dtos.CocktailDTO;
import com.example.cocktailcompass.cocktail.exceptions.FavouriteCocktailServiceException;
import com.example.cocktailcompass.cocktail.models.FavouriteCocktail;

public interface FavouriteCocktailService {

    CocktailDTO saveFavouriteCocktail(CocktailDTO cocktailDTO) throws FavouriteCocktailServiceException;
}
