package com.life.onespring.tacos.JDBC;
import java.util.List;
import java.util.Optional;

import com.life.onespring.tacos.Ingredient;

public interface IngredientRepo {
    // repo abstraction for ingredients access

    List<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);

}