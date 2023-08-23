package com.oit;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String home() {
        return "home"; // Return the name of the Thymeleaf template (home.html)
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Return the name of the Thymeleaf template (login.html)
    }
    @GetMapping("/sign")
    public String sign() {
        return "home"; // Return the name of the Thymeleaf template (login.html)
    }
    @GetMapping("/normal")
    public ResponseEntity<String> normalUser() {
        return ResponseEntity.ok("yes,i am normal user");
    }
    @GetMapping("/admin")
    public ResponseEntity<String> adminUser() {
        return ResponseEntity.ok("yes,i am admin user");
    }
    @GetMapping("/public")
    public ResponseEntity<String> publicUser() {
        return ResponseEntity.ok("yes,i am public user");
    }
    
}
