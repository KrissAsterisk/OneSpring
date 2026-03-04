package com.life.onespring;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoggingController {

    Logger logger = LogManager.getLogger(LoggingController.class); // same as @Slf4j

    @RequestMapping("/logs")
    public String logs(){
        logger.info("Info...");
        logger.trace("Tracing...");
        logger.debug("Debug...");
        logger.warn("Warning...");
        logger.error("Error...");
        return "Logging: . . .";
    }
}
