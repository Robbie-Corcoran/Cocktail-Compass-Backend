package com.example.cocktailcompass.cocktail.sevices;

import com.example.cocktailcompass.cocktail.exceptions.favouriteCocktail.FavouriteCocktailAlreadyExistsException;
import com.example.cocktailcompass.cocktail.exceptions.favouriteCocktail.FavouriteCocktailNotFoundException;
import com.example.cocktailcompass.cocktail.models.CocktailEntity;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import com.example.cocktailcompass.cocktail.repositories.FavouriteCocktailRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("favouriteCocktailService")
public class FavouriteCocktailServiceImpl implements FavouriteCocktailService {

    FavouriteCocktailRepository favouriteCocktailRepository;

    @Autowired
    public FavouriteCocktailServiceImpl(FavouriteCocktailRepository favouriteCocktailRepository) {
        this.favouriteCocktailRepository = favouriteCocktailRepository;
    }

    @Override
    public CocktailDTO saveFavouriteCocktail(CocktailDTO cocktailDTO) throws FavouriteCocktailAlreadyExistsException {

        ModelMapper modelMapper = new ModelMapper();

        if (favouriteCocktailRepository.existsByIdDrink(cocktailDTO.getIdDrink())) {
            throw new FavouriteCocktailAlreadyExistsException("Cocktail already favourite.");
        }

        cocktailDTO.setFavourite(true);
        CocktailEntity favouriteCocktailEntity = modelMapper.map(cocktailDTO, CocktailEntity.class);

        favouriteCocktailRepository.save(favouriteCocktailEntity);
        return modelMapper.map(favouriteCocktailEntity, CocktailDTO.class);
    }

    @Override
    public List<CocktailDTO> findAllFavouriteCocktails() throws FavouriteCocktailNotFoundException {
        ModelMapper modelMapper = new ModelMapper();
        List<CocktailEntity> cocktailEntities = favouriteCocktailRepository.findAll();

        if (cocktailEntities.isEmpty()) {
            throw new FavouriteCocktailNotFoundException("No FavouriteCocktails found.");
        }

        List<CocktailDTO> cocktailDTOs = new ArrayList<>();

        for (CocktailEntity cocktailEntity : cocktailEntities) {
            CocktailDTO cocktailDTO = modelMapper.map(cocktailEntity, CocktailDTO.class);
            cocktailDTOs.add(cocktailDTO);
        }

        return cocktailDTOs;
    }

    @Override
    public void deleteFavouriteCocktail(Integer idDrink) throws FavouriteCocktailNotFoundException {
        if (!favouriteCocktailRepository.existsByIdDrink(idDrink)) {
            throw new FavouriteCocktailNotFoundException("idDrink not found in Favourites.");
        }
        favouriteCocktailRepository.deleteById(idDrink);
    }
}
