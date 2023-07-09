package com.example.cocktailcompass.cocktail.models;

import jakarta.persistence.*;

@Entity
public class FavouriteCocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "drinkId", nullable = false)
    private int drinkId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "iba")
    private String iba;

    @Column(name = "glass")
    private String glass;

    @Column(name = "instructions")
    private String instructions;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "strIngredient1")
    private String strIngredient1;

    @Column(name = "strIngredient2")
    private String strIngredient2;

    @Column(name = "strIngredient3")
    private String strIngredient3;

    @Column(name = "strIngredient4")
    private String strIngredient4;

    @Column(name = "strIngredient5")
    private String strIngredient5;

    @Column(name = "strIngredient6")
    private String strIngredient6;

    @Column(name = "strIngredient7")
    private String strIngredient7;

    @Column(name = "strIngredient8")
    private String strIngredient8;

    @Column(name = "strIngredient9")
    private String strIngredient9;

    @Column(name = "strIngredient10")
    private String strIngredient10;

    @Column(name = "strIngredient11")
    private String strIngredient11;

    @Column(name = "strIngredient12")
    private String strIngredient12;

    @Column(name = "strIngredient13")
    private String strIngredient13;

    @Column(name = "strIngredient14")
    private String strIngredient14;

    @Column(name = "strIngredient15")
    private String strIngredient15;

    @Column(name = "strMeasure1")
    private String strMeasure1;

    @Column(name = "strMeasure2")
    private String strMeasure2;

    @Column(name = "strMeasure3")
    private String strMeasure3;

    @Column(name = "strMeasure4")
    private String strMeasure4;

    @Column(name = "strMeasure5")
    private String strMeasure5;

    @Column(name = "strMeasure6")
    private String strMeasure6;

    @Column(name = "strMeasure7")
    private String strMeasure7;

    @Column(name = "strMeasure8")
    private String strMeasure8;

    @Column(name = "strMeasure9")
    private String strMeasure9;

    @Column(name = "strMeasure10")
    private String strMeasure10;

    @Column(name = "strMeasure11")
    private String strMeasure11;

    @Column(name = "strMeasure12")
    private String strMeasure12;

    @Column(name = "strMeasure13")
    private String strMeasure13;

    @Column(name = "strMeasure14")
    private String strMeasure14;

    @Column(name = "strMeasure15")
    private String strMeasure15;

    public String getName() {
        return name;
    }
}
