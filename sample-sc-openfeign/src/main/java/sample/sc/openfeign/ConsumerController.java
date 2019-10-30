package sample.sc.openfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.sc.openfeign.client.OrderFeignClient;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private OrderFeignClient orderFeignClient;

    @GetMapping("/checkHelloHealth")
    public String checkHelloHealth() {
        return orderFeignClient.health();
    }
}
