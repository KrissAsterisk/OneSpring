package com.life.onespring.tacos.web;


import com.life.onespring.LoggingController;
import com.life.onespring.tacos.Ingredient;
import com.life.onespring.tacos.Taco;
import com.life.onespring.tacos.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Model passes data between a controller and whatever view is charged with rendering that data
 */



@Slf4j //lombok - logger
@Controller // mark for component scanning - created as a bean in the Spring application context
@RequestMapping("/Design Your Taco") // at class level -> this controller handles paths starting with /design | same as @GetMapping("/design") on all
@SessionAttributes("tacoOrder")// TacoOrder is put into the model later on in this class, so maintain it in the session
public class DesignTacoController {

    @ModelAttribute // method invoked when a request is made to /design
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGETABLE),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGETABLE),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE),
                new Ingredient("MUSH", "Mushrooms", Ingredient.Type.VEGETABLE),
                new Ingredient("PEPP", "Pepperoni", Ingredient.Type.PROTEIN),
                new Ingredient("BBQ", "Barbeque", Ingredient.Type.SAUCE)

        );

        for (var type : Ingredient.Type.values()) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
            // list of ingredient types added as an attribute to the model object that is passed to the view (showDesignForm)
        }
    }
    @ModelAttribute(name = "tacoOrder") // place a new tacoOrder object in the model
    public TacoOrder tacoOrder() {
        return new TacoOrder();
    }
    @ModelAttribute(name = "taco") // place a new taco object in the model
    public Taco taco() {
        return new Taco();
    }

    @PostMapping
    public String processTaco(Taco taco, @ModelAttribute TacoOrder tacoOrder) {
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);
        return "redirect:orders/current";
    }

    @GetMapping // call showDesignForm when an HTTP Get request is made to /design
    public String showDesignForm(Model model) {
        model.addAttribute("pages", com.life.onespring.HelperClass.getPagesList());
        return "/TacoFactory/Design Your Taco";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
