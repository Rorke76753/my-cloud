package my.consumer.demo.consume;

import my.consumer.demo.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeController {
    private final LoadBalancerClient loadBalancerClient;
    private final DiscoveryClient discoveryClient;
    private final FeignService feignService;

    @Autowired
    public ConsumeController(LoadBalancerClient loadBalancerClient, DiscoveryClient discoveryClient, FeignService feignService) {
        this.loadBalancerClient = loadBalancerClient;
        this.discoveryClient = discoveryClient;
        this.feignService = feignService;
    }

    @GetMapping("/services")
    public Object getServices(){
        return discoveryClient.getInstances("consul-user-service");
    }

    @GetMapping("/discover")
    public Object getOneService() {
        return loadBalancerClient.choose("consul-user-service").getUri().toString();
    }

    @GetMapping("/call")
    public String callService(){
        return feignService.hello();
    }
}
