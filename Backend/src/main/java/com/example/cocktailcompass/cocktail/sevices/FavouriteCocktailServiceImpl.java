package com.example.cocktailcompass.cocktail.sevices;

import com.example.cocktailcompass.cocktail.dtos.CocktailDTO;
import com.example.cocktailcompass.cocktail.exceptions.FavouriteCocktailServiceException;
import com.example.cocktailcompass.cocktail.models.FavouriteCocktail;
import com.example.cocktailcompass.cocktail.repositories.FavouriteCocktailRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("favouriteCocktailService")
public class FavouriteCocktailServiceImpl implements FavouriteCocktailService {

    FavouriteCocktailRepository favouriteCocktailRepository;

    @Autowired
    public FavouriteCocktailServiceImpl(FavouriteCocktailRepository favouriteCocktailRepository){
        this.favouriteCocktailRepository = favouriteCocktailRepository;
    }

    @Override
    public CocktailDTO saveFavouriteCocktail(CocktailDTO cocktailDTO) throws FavouriteCocktailServiceException {

        if (favouriteCocktailRepository.findById((long) cocktailDTO.getIdDrink()).isPresent()) {
            throw new FavouriteCocktailServiceException("Cocktail already favourited.");
        }

        ModelMapper modelMapper = new ModelMapper();
        cocktailDTO.setFavourite(true);
        FavouriteCocktail favouriteCocktailEntity = modelMapper.map(cocktailDTO, FavouriteCocktail.class);
        FavouriteCocktail storedFavouriteCocktail = favouriteCocktailRepository.save(favouriteCocktailEntity);

        return modelMapper.map(storedFavouriteCocktail, CocktailDTO.class);
    }
}
