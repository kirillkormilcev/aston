package ru.kormilcev.aston;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TomcatController {

    @GetMapping("/")
    public String sayHello() {
        return "Привет!";
    }
}
