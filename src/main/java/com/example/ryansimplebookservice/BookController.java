package com.example.ryansimplebookservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring!";
    }
}
