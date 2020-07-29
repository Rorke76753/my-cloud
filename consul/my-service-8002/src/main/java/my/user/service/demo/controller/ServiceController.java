package my.user.service.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ServiceController {
    @GetMapping("/hello")
    public String hello(){
        return "hello "+ LocalDateTime.now();
    }
}
