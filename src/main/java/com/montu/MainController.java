package com.montu;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    @GetMapping("")
    public String showHomePage(){
        return "Hello world in spring boot";
    }
    @GetMapping("/hello")
    public ResponseEntity<Map<String, String>> welcome() {
        Map<String, String> response = new HashMap<>();
        response.put("success", "true");
        response.put("message", "Welcome to SpringBoot  backend");
        return ResponseEntity.ok(response);
    }
}
