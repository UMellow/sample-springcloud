package sample.sc.openfeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "order-service", url = "localhost:8080")
@RequestMapping("/order")
public interface OrderFeignClient {

    @GetMapping("/health")
    public String health();
}
