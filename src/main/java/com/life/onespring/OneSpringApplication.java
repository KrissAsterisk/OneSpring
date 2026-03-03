package com.life.onespring;


import com.life.onespring.UserTypes.Admin;
import com.life.onespring.UserTypes.Guest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.function.Consumer;

@SpringBootApplication
public class OneSpringApplication {


    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(OneSpringApplication.class);
        builder.application().setLazyInitialization(true);
        ApplicationContext context = builder.run(args);
        context.getBean(Guest.class).login().getID();
        context.getBean(Admin.class).login().getID();


    }
}

