package com.example.cocktailcompass.cocktail.sevices;

import com.example.cocktailcompass.cocktail.exceptions.FavouriteCocktailException;
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
    public CocktailDTO saveFavouriteCocktail(CocktailDTO cocktailDTO) throws FavouriteCocktailException {

        ModelMapper modelMapper = new ModelMapper();

        if (favouriteCocktailRepository.existsByIdDrink(cocktailDTO.getIdDrink())) {
            throw new FavouriteCocktailException("Cocktail already favourite.");
        }
        if (cocktailDTO.getStrDrink() == null || cocktailDTO.getStrDrink().isEmpty()) {
            throw new FavouriteCocktailException("Drink name cannot be null or empty.");
        }

        cocktailDTO.setFavourite(true);
        CocktailEntity favouriteCocktailEntity = modelMapper.map(cocktailDTO, CocktailEntity.class);

        favouriteCocktailRepository.save(favouriteCocktailEntity);
        return modelMapper.map(favouriteCocktailEntity, CocktailDTO.class);
    }

    @Override
    public List<CocktailDTO> findAllFavouriteCocktails() throws FavouriteCocktailException {
        ModelMapper modelMapper = new ModelMapper();
        List<CocktailEntity> cocktailEntities = favouriteCocktailRepository.findAll();

        if (cocktailEntities.isEmpty()) {
            throw new FavouriteCocktailException("FavouriteCocktails list returned empty");
        }

        List<CocktailDTO> cocktailDTOs = new ArrayList<>();

        for (CocktailEntity cocktailEntity : cocktailEntities) {
            CocktailDTO cocktailDTO = modelMapper.map(cocktailEntity, CocktailDTO.class);
            cocktailDTOs.add(cocktailDTO);
        }

        return cocktailDTOs;
    }

    @Override
    public void deleteFavouriteCocktail(Integer idDrink) {
        favouriteCocktailRepository.deleteById(idDrink);
    }
}
