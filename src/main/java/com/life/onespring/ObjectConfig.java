package com.life.onespring;

import com.life.onespring.UserTypes.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.WebApplicationContext;

/**
 * This is a configuration class that will provide beans to the Spring application context.
 * <p>
 * Methods annotated with @Bean indicating that the object they return should be added as beans in the application context.
 * Their Bean IDS will be the same as the method names.
 */
@Configuration
public class ObjectConfig {

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Guest guest(){
        return new Guest();
    }

    @Bean
    public Admin admin(){
        return new Admin();
    }

}
