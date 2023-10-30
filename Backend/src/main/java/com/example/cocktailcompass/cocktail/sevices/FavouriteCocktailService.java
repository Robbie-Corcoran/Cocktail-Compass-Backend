package com.example.cocktailcompass.cocktail.sevices;

import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import com.example.cocktailcompass.cocktail.exceptions.FavouriteCocktailServiceException;

import java.util.List;

public interface FavouriteCocktailService {

    CocktailDTO saveFavouriteCocktail(CocktailDTO cocktailDTO) throws FavouriteCocktailServiceException;

    List<CocktailDTO> findAllFavouriteCocktails();

    void deleteFavouriteCocktail(Long id);

    }
