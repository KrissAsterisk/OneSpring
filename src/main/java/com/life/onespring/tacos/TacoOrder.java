package com.life.onespring.tacos;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TacoOrder implements java.io.Serializable{

    @Serial
    private static final long serialVersionUID = 1L;
    private long id;
    private Date placedAt;

    @NotBlank(message = "Delivery Name is required")
    private String deliveryName;
    @NotBlank(message = "Delivery Street is required")
    private String deliveryStreet;
    @NotBlank(message = "Delivery City is required")
    private String deliveryCity;
    @NotBlank(message = "Delivery State is required")
    private String deliveryState;
    @NotBlank(message = "Delivery Zip is required")
    private String deliveryZip;
    @CreditCardNumber(message = "Credit Card Number is invalid")
    private String ccNumber;
    @Pattern(regexp = "\\d{2}/\\d{2}", message = "Credit Card Expiration is invalid, MM/YY")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Credit Card CVV must be 3 digits")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco){
        tacos.add(taco);
    }
}
