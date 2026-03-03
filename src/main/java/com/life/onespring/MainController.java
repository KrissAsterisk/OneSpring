package com.life.onespring;


import com.life.onespring.UserTypes.Admin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.stereotype.Controller
public class MainController {
    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/exit")
    public String exit(ApplicationContext context){
        context.getBean(Admin.class).close();
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
