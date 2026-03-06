package com.life.onespring.tacos;


import lombok.Data; // creates getter&setter methods + toString() etc like a record

@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        FRUIT, VEGGIES, MEAT, DAIRY, GRAIN, OIL, SWEETENER, SAUCE, SPICE, SEED,
        FLOUR,
        CHEESE, PROTEIN, WRAP,
        OTHER;
    }
}
