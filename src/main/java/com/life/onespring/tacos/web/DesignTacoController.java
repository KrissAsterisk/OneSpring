package com.life.onespring.tacos.web;

import com.life.onespring.tacos.Ingredient;
import com.life.onespring.tacos.JDBC.IngredientRepo;
import com.life.onespring.tacos.Taco;
import com.life.onespring.tacos.TacoOrder;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;



/**
 * Model passes data between a controller and whatever view is charged with rendering that data
 */


@Slf4j //lombok - logger
@Controller // mark for component scanning - created as a bean in the Spring application context
@RequestMapping("/Design Your Taco")
// at class level -> this controller handles paths starting with /design | same as @GetMapping("/design") on all
@SessionAttributes("tacoOrder")// TacoOrder is put into the model later on in this class, so maintain it in the session
// the above tells Spring:
//      if tacoOrder is added to the model, keep it in the user's session across requests
//      if a user designs taco #1, then taco#2, they keep building the same order
//      without this, every request creates a new TacoOrder
public class DesignTacoController {

    private final IngredientRepo repo;

    @Autowired
    public DesignTacoController(IngredientRepo repo) { // injection
        this.repo = repo;
    //  this says that the controller depends on a repository to fetch ingredients
        // aka a dependency injection
        // instead of the controller creating its own repo instance, Spring provides it
    }

    //This mtd runs b4 every request to /Design Your Taco
    // it loads all ingredients into the model from the database, identified as repo
    // which is then rendered onto the page using Thymeleaf
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = repo.findAll();

        for (Ingredient.Type type : Ingredient.Type.values()) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
            // list of ingredient types added as an attribute to the model object that is passed to the view (showDesignForm)
            // MODEL: model is data sent from controller to view
            // Thymeleaf template can read these values and render HTML
        }

    }

    // these attributes create default tacoOrder and taco objects so the form has something to bind to
    @ModelAttribute(name = "tacoOrder") // place a new tacoOrder object in the model
    public TacoOrder tacoOrder() {
        return new TacoOrder();
    }

    // in essence, b4 rendering or binding this page, i need a TacoOrder and a Taco ready
    @ModelAttribute(name = "taco") // place a new taco object in the model
    public Taco taco() {
        return new Taco();
    }

    @PostMapping // this receives user submitted taco form
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {
        if(errors.hasErrors()) {
            return "TacoFactory/Design Your Taco";
        }
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);
        return "redirect:orders/current";

        // Valid + Errors -> Spring validates Taco against the annotations in the model class
        // if it fails, errors will be populated with the validation errors
        // if it succeeds, the user is redirected to the order form
    }


    @GetMapping // call showDesignForm when an HTTP Get request is made to /design
    public String showDesignForm(Model model) {
        return "/TacoFactory/Design Your Taco";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients.stream()
                .filter( x-> x.getType().equals(type))
                .collect(Collectors.toList());
        // this takes all ingredients and returns only the ones belonging to one category
        // done for presentation
    }

}
