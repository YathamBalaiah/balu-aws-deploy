package com.ypa.reactjsex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class ReactJsAndSpringBootApplication {
	   private static final Logger logger = (Logger) LoggerFactory.getLogger(ReactJsAndSpringBootApplication.class);


	public static void main(String[] args) {
		logger.info("this is a info message");
	      logger.warn("this is a warn message");
	      logger.debug("this is a debug message");

	      logger.error("this is a error message");
		
		SpringApplication.run(ReactJsAndSpringBootApplication.class, args);
	}

}
