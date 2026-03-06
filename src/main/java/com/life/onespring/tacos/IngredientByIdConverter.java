package com.life.onespring.tacos;


import com.life.onespring.tacos.JDBC.IngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component // discoverable as a bean in the application context
public class IngredientByIdConverter implements Converter<String, Ingredient>{
   private final IngredientRepo repo;

   @Autowired
    public IngredientByIdConverter(IngredientRepo repo) {
        this.repo = repo;
    }

    @Override
    public Ingredient convert(String id) {
        return repo.findById(id).orElse(null);
    }
}
