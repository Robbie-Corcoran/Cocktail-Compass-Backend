package com.example.cocktailcompass.cocktail.controllers;

import com.example.cocktailcompass.cocktail.sevices.FavouriteCocktailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(FavouriteCocktailController.class)
public class FavouriteCocktailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FavouriteCocktailServiceImpl favouriteCocktailService;



}
