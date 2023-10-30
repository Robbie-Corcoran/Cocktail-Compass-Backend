package com.example.cocktailcompass.cocktail.sevices;

import com.example.cocktailcompass.cocktail.models.CocktailEntity;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import com.example.cocktailcompass.cocktail.repositories.FavouriteCocktailRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("favouriteCocktailService")
public class FavouriteCocktailServiceImpl implements FavouriteCocktailService {

    FavouriteCocktailRepository favouriteCocktailRepository;

    @Autowired
    public FavouriteCocktailServiceImpl(FavouriteCocktailRepository favouriteCocktailRepository) {
        this.favouriteCocktailRepository = favouriteCocktailRepository;
    }

    @Override
    public CocktailDTO saveFavouriteCocktail(CocktailDTO cocktailDTO) {

        ModelMapper modelMapper = new ModelMapper();

//        if (favouriteCocktailRepository.existsByIdDrink(cocktailDTO.getIdDrink())) {
//            throw new FavouriteCocktailServiceException("Cocktail already favourited.");
//        }
//        if (cocktailDTO.getStrDrink() == null || cocktailDTO.getStrDrink().isEmpty()) {
//            throw new FavouriteCocktailServiceException("Drink name cannot be null or empty.");
//        }

//        cocktailDTO.setFavourite(true);
        CocktailEntity favouriteCocktailEntity = modelMapper.map(cocktailDTO, CocktailEntity.class);
        CocktailEntity storedFavouriteCocktail = favouriteCocktailRepository.save(favouriteCocktailEntity);

        return modelMapper.map(storedFavouriteCocktail, CocktailDTO.class);
    }

    @Override
    public List<CocktailDTO> findAllFavouriteCocktails() {
        ModelMapper modelMapper = new ModelMapper();
        return (List<CocktailDTO>) modelMapper.map(favouriteCocktailRepository.findAll(), CocktailDTO.class);
    }

    @Override
    public void deleteFavouriteCocktail(Integer idDrink) {
        favouriteCocktailRepository.deleteById(idDrink);
    }
}
