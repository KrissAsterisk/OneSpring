package com.life.onespring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

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
        return "Discord";
    }

    @GetMapping("/Game Review")
    public String g_rev(Model model) {
        return "Game Review";
    }

    @GetMapping("/My Contact Info")
    public String gmail(Model model) {
        return "My Contact Info";
    }

    @GetMapping("/Game Review Part 2")
    public String grev2(Model model) {
        return "Game Review Part 2";
    }

    @GetMapping({"/Lobby", "/"})
    public String homePage(Model model) {
        return "Lobby";
    }

    @GetMapping("/Phoenix Wright ROM Links")
    public String PWI(Model model) {
        return "Phoenix Wright ROM Links";
    }

    @GetMapping("/Discord Rules")
    public String rules(Model model) {
        return "Discord Rules";

    }

    @GetMapping("/My YouTube")
    public String ytb(Model model) {
        return "My YouTube";
    }
}
