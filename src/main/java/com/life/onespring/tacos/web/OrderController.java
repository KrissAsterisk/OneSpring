package com.life.onespring.tacos.web;


import com.life.onespring.tacos.JDBC.OrderRepository;
import com.life.onespring.tacos.TacoOrder;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller // it handles the order finalization step
// after a taco is designed the user goes here to enter delivery&payment info and submit the whole order ( which contains at least 1 or multiple tacos designed by the user)
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) { // dependant on OrderRepository
        this.orderRepository = orderRepository;
        // this is the repository abstraction for saving orders
        // the controller should not know how the order is stored
        // it knows that it can save an order through the interface called OrderRepository
    }

    @GetMapping("/current")
    public String orderForm() {
        return "TacoFactory/orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus) {
        if(errors.hasErrors()) {
            return orderForm();
        }
        orderRepository.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
        // Here is a new concept: SessionStatus
        // tells Spring that the session-scoped form object is done now; clear it with .setComplete()
        // otherwise the old order might stay in session and leak into the next order
    }

}
