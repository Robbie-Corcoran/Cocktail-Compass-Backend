package com.example.cocktailcompass.cocktail;

import java.util.List;

public interface ICocktailRepository {
    List<Cocktail> searchCocktails(String searchQuery);
}
