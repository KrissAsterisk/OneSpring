package com.life.onespring;


import com.life.onespring.UserTypes.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import jakarta.servlet.http.HttpServletRequest;

import static com.life.onespring.HelperClass.getPagesList;


@Controller
public class MainController {
    @Value("${spring.application.name}")
    private String appName;
    private final Guest guest;

    public MainController(Guest guest) { // injection
        this.guest = guest.login();
    }


    @GetMapping("/exit")
    public String exit() {
        System.exit(0);
        return "";
    }

    @GetMapping("/error")
    public String error() {
        return "redirect:/Lobby";
    }

    @GetMapping("/Discord")
    public String discord(Model model) {
        model.addAttribute("pages", getPagesList());
        return "Discord";
    }

    @GetMapping("/Game Review")
    public String g_rev(Model model) {
        model.addAttribute("pages", getPagesList());
        return "Game Review";
    }

    @GetMapping("/My Contact Info")
    public String gmail(Model model) {
        model.addAttribute("pages", getPagesList());
        return "My Contact Info";
    }

    @GetMapping("/Game Review Part 2")
    public String grev2(Model model) {
        model.addAttribute("pages", getPagesList());
        return "Game Review Part 2";
    }

    @GetMapping({"/Lobby", "/"})
    public String homePage(Model model) {
        return "Lobby";
    }

    @ModelAttribute
    public void switchPage(Model model, HttpServletRequest request) {
        model.addAttribute("appName", appName);
        model.addAttribute("pages", getPagesList());

        model.addAttribute("guest", guest);
        model.addAttribute("guestId", guest.getId());
        System.out.printf(guest.getId() +" ");
        System.out.println("Switched Page: " + request.getMethod() + " " + request.getRequestURI());
    }

    @GetMapping("/Phoenix Wright ROM Links")
    public String PWI(Model model) {
        model.addAttribute("pages", getPagesList());
        return "Phoenix Wright ROM Links";
    }

    @GetMapping("/Discord Rules")
    public String rules(Model model) {
        model.addAttribute("pages", getPagesList());
        return "Discord Rules";

    }

    @GetMapping("/My YouTube")
    public String ytb(Model model) {
        model.addAttribute("pages", getPagesList());
        return "My YouTube";
    }
}
