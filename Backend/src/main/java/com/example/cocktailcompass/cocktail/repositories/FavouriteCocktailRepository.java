package com.example.cocktailcompass.cocktail.repositories;

import com.example.cocktailcompass.cocktail.models.FavouriteCocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FavouriteCocktailRepository extends CrudRepository<FavouriteCocktail, Long> {
}
