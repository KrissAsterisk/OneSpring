package com.life.onespring;


import com.life.onespring.UserTypes.Admin;
import com.life.onespring.UserTypes.Guest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.stereotype.Controller
public class MainController {
    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/exit")
    public String exit() {
        System.exit(0);
        return "";
    }

    @GetMapping("/discord")
    public String discord() {
        return "discord";
    }

    @GetMapping("/g_rev")
    public String g_rev() {
        return "g_rev";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/gmail")
    public String gmail() {
        return "gmail";
    }

    @GetMapping("/grev2")
    public String grev2() {
        return "grev2";
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        var guest = new Guest().login();
        model.addAttribute("guest", guest);
        model.addAttribute("guestID", guest.getID());

        return "main";
    }

    @GetMapping("/PWl")
    public String PWI() {
        return "PWl";
    }

    @GetMapping("/rules")
    public String rules() {
        return "rules";

    }

    @GetMapping("/ytb")
    public String ytb() {
        return "ytb";
    }
}
