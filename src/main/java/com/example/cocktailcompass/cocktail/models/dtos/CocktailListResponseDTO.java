package com.example.cocktailcompass.cocktail.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CocktailListResponseDTO {

    @JsonProperty("drinks")
    private List<CocktailDTO> cocktailDTOList;


    public List<CocktailDTO> getCocktails() {
        return cocktailDTOList;

    }

    public void setCocktails(List<CocktailDTO> cocktailDTOList) {
        this.cocktailDTOList = cocktailDTOList;
    }

}
