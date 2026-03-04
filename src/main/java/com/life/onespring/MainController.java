package com.life.onespring;


import com.life.onespring.UserTypes.Guest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@org.springframework.stereotype.Controller
public class MainController {
    @Value("${spring.application.name}")
    private String appName;


    @GetMapping("/exit")
    public String exit() {
        System.exit(0);
        return "";
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
        model.addAttribute("appName", appName);
        var guest = new Guest().login();
        model.addAttribute("guest", guest);
        model.addAttribute("guestId", guest.getID());
        model.addAttribute("pages", getPagesList());

        return "Lobby";
    }

    @ModelAttribute
    public void switchPage(Model model) {
        System.out.println("Switched Page");
        System.out.println(model.getAttribute("guestId"));
        System.out.println(model.getAttribute("guest"));
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

    private java.util.List<String> getPagesList() {
        return java.util.Arrays.asList("Lobby", "Discord", "Game Review", "My Contact Info", "Discord Rules", "My YouTube");
    }
}
