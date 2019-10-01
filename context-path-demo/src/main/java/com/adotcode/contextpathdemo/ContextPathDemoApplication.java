package com.adotcode.contextpathdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author risfeng
 */
@SpringBootApplication
public class ContextPathDemoApplication {

  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(ContextPathDemoApplication.class);
    application.run(args);
  }

}
