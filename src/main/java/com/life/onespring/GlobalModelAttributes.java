package com.life.onespring;

import com.life.onespring.UserTypes.Guest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import static com.life.onespring.HelperClass.getPagesList;

@ControllerAdvice
public class GlobalModelAttributes {

    @Value("${spring.application.name}")
    private String appName;

    private final Guest guest;

    public GlobalModelAttributes(Guest guest) {
        this.guest = guest.login(); // if Guest is session-scoped, this will resolve per-session
    }

    @ModelAttribute
    public void addCommonAttributes(Model model, HttpServletRequest request) {
        model.addAttribute("appName", appName);
        model.addAttribute("pages", getPagesList());
        model.addAttribute("guest", guest);
        model.addAttribute("guestId", guest.getId());

        // Prefer a logger over System.out in real apps
        System.out.printf(guest.getId() + " ");
        System.out.println("Switched Page: " + request.getMethod() + " " + request.getRequestURI());
    }
}