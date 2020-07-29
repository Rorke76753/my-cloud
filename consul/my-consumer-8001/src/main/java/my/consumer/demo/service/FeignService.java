package my.consumer.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("consul-user-service")
@Component
public interface FeignService {
    @RequestMapping(value = "/hello")
     String hello();
}
