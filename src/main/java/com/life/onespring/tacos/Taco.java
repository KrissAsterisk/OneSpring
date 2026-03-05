package com.life.onespring.tacos;

import com.life.onespring.tacos.web.DesignTacoController;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;


@Data
public class Taco {
    @NotNull
    @Size(min = 5, message = "Taco name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}
