package com.example.cocktailcompass.cocktail.sevices;

import com.example.cocktailcompass.cocktail.exceptions.FavouriteCocktailException;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;

import java.util.List;

public interface FavouriteCocktailService {

    CocktailDTO saveFavouriteCocktail(CocktailDTO cocktailDTO) throws FavouriteCocktailException;

    List<CocktailDTO> findAllFavouriteCocktails() throws FavouriteCocktailException;

    void deleteFavouriteCocktail(Integer idDrink);

}
