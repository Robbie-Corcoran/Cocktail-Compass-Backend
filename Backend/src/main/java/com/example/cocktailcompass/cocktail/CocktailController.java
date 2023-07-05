package com.example.cocktailcompass.cocktail;

import org.springframework.web.bind.annotation.*;

@RestController
public class CocktailController {

    @GetMapping(path = "/hello")
    @ResponseBody
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name){
        return String.format("Hello %s!", name);
    }


}
