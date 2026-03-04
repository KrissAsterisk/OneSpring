package com.life.onespring.tacos;

import lombok.Data; // creates getter&setter methods + toString() etc like a record

@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        FRUIT, VEGETABLE, MEAT, DAIRY, GRAIN, OIL, SWEETENER, SAUCE, SPICE, SEED,
        FLOUR, SUGAR, HONEY, CREAM, CHOCOLATE, SALT, PAPER, PASTE,
        CHEESE, PROTEIN, WRAP,
        OTHER
    }
}
