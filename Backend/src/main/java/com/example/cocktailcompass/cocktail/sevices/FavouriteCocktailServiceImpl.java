package com.example.cocktailcompass.cocktail.sevices;

import com.example.cocktailcompass.cocktail.models.CocktailEntity;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import com.example.cocktailcompass.cocktail.exceptions.FavouriteCocktailServiceException;
import com.example.cocktailcompass.cocktail.repositories.FavouriteCocktailRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("favouriteCocktailService")
public class FavouriteCocktailServiceImpl implements FavouriteCocktailService {

    FavouriteCocktailRepository favouriteCocktailRepository;

    @Autowired
    public FavouriteCocktailServiceImpl(FavouriteCocktailRepository favouriteCocktailRepository){
        this.favouriteCocktailRepository = favouriteCocktailRepository;
    }

    @Override
    public CocktailDTO saveFavouriteCocktail(CocktailDTO cocktailDTO) throws FavouriteCocktailServiceException {

        if (favouriteCocktailRepository.existsByIdDrink(cocktailDTO.getIdDrink())) {
            throw new FavouriteCocktailServiceException("Cocktail already favourited.");
        }

        ModelMapper modelMapper = new ModelMapper();
        cocktailDTO.setFavourite(true);
        CocktailEntity favouriteCocktailEntity = modelMapper.map(cocktailDTO, CocktailEntity.class);
        CocktailEntity storedFavouriteCocktail = favouriteCocktailRepository.save(favouriteCocktailEntity);

        return modelMapper.map(storedFavouriteCocktail, CocktailDTO.class);
    }
}
