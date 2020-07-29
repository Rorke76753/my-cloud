package example.cloud.nacos.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string){
        return "Hello Nacos Discovery "+string;
    }
}
