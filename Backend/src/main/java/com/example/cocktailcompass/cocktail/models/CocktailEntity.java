package com.example.cocktailcompass.cocktail.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@SuppressWarnings("ALL")
@Entity
public class CocktailEntity {

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idDrink", nullable = false)
    @JsonProperty("idDrink")
    private int idDrink;

    @JsonProperty("strDrink")
    @Column(name = "strDrink", nullable = false)
    private String strDrink;

    @JsonProperty("isFavourite")
    @Column(name = "isFavourite", columnDefinition = "boolean default false")
    private boolean isFavourite;

    @JsonProperty("strIBA")
    @Column(name = "strIBA")
    private String strIBA;

    @JsonProperty("strGlass")
    @Column(name = "strGlass")
    private String strGlass;

    @JsonProperty("strInstructions")
    @Column(name = "strInstructions", length = 1024)
    private String strInstructions;

    @JsonProperty("strDrinkThumb")
    @Column(name = "strDrinkThumb")
    private String strDrinkThumb;

    @JsonProperty("strIngredient1")
    @Column(name = "strIngredient1")
    private String strIngredient1;

    @JsonProperty("strIngredient2")
    @Column(name = "strIngredient2")
    private String strIngredient2;

    @JsonProperty("strIngredient3")
    @Column(name = "strIngredient3")
    private String strIngredient3;

    @JsonProperty("strIngredient4")
    @Column(name = "strIngredient4")
    private String strIngredient4;

    @JsonProperty("strIngredient5")
    @Column(name = "strIngredient5")
    private String strIngredient5;

    @JsonProperty("strIngredient6")
    @Column(name = "strIngredient6")
    private String strIngredient6;

    @JsonProperty("strIngredient7")
    @Column(name = "strIngredient7")
    private String strIngredient7;

    @JsonProperty("strIngredient8")
    @Column(name = "strIngredient8")
    private String strIngredient8;

    @JsonProperty("strIngredient9")
    @Column(name = "strIngredient9")
    private String strIngredient9;

    @JsonProperty("strIngredient10")
    @Column(name = "strIngredient10")
    private String strIngredient10;

    @JsonProperty("strIngredient11")
    @Column(name = "strIngredient11")
    private String strIngredient11;

    @JsonProperty("strIngredient12")
    @Column(name = "strIngredient12")
    private String strIngredient12;

    @JsonProperty("strIngredient13")
    @Column(name = "strIngredient13")
    private String strIngredient13;

    @JsonProperty("strIngredient14")
    @Column(name = "strIngredient14")
    private String strIngredient14;

    @JsonProperty("strIngredient15")
    @Column(name = "strIngredient15")
    private String strIngredient15;

    @JsonProperty("strMeasure1")
    @Column(name = "strMeasure1")
    private String strMeasure1;

    @JsonProperty("strMeasure2")
    @Column(name = "strMeasure2")
    private String strMeasure2;

    @JsonProperty("strMeasure3")
    @Column(name = "strMeasure3")
    private String strMeasure3;

    @JsonProperty("strMeasure4")
    @Column(name = "strMeasure4")
    private String strMeasure4;

    @JsonProperty("strMeasure5")
    @Column(name = "strMeasure5")
    private String strMeasure5;

    @JsonProperty("strMeasure6")
    @Column(name = "strMeasure6")
    private String strMeasure6;

    @JsonProperty("strMeasure7")
    @Column(name = "strMeasure7")
    private String strMeasure7;

    @JsonProperty("strMeasure8")
    @Column(name = "strMeasure8")
    private String strMeasure8;

    @JsonProperty("strMeasure9")
    @Column(name = "strMeasure9")
    private String strMeasure9;

    @JsonProperty("strMeasure10")
    @Column(name = "strMeasure10")
    private String strMeasure10;

    @JsonProperty("strMeasure11")
    @Column(name = "strMeasure11")
    private String strMeasure11;

    @JsonProperty("strMeasure12")
    @Column(name = "strMeasure12")
    private String strMeasure12;

    @JsonProperty("strMeasure13")
    @Column(name = "strMeasure13")
    private String strMeasure13;

    @JsonProperty("strMeasure14")
    @Column(name = "strMeasure14")
    private String strMeasure14;

    @JsonProperty("strMeasure15")
    @Column(name = "strMeasure15")
    private String strMeasure15;

}
