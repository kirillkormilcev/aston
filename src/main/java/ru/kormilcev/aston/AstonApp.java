package ru.kormilcev.aston;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AstonApp extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AstonApp.class, args);
    }
}
