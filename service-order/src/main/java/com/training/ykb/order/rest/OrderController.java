package com.training.ykb.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.training.ykb.order.model.Order;
import com.training.ykb.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    @Qualifier("os")
    private OrderService orSer;

    private int          count = 0;

    @HystrixCommand(fallbackMethod = "fallbackCurBrerakerTest",
                    commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                                                         value = "500"))
    @GetMapping("/test")
    public String curBrerakerTest() {
        this.count++;
        if ((this.count % 3) == 0) {
            throw new IllegalArgumentException();
        }
        if ((this.count % 5) == 0) {
            try {
                Thread.sleep(1000);
            } catch (Exception eLoc) {
            }
        }

        return "Hello world";
    }

    public String fallbackCurBrerakerTest() {
        return "Hello world test";
    }

    @PostMapping("/place")
    public String placeOrder(@Validated @RequestBody final Order order) {
        return this.orSer.placeOrder(order);
    }

    @PostMapping("/place2")
    public String placeOrder2(@Validated @RequestBody final Order order) {
        return this.orSer.placeOrder2(order);
    }

    @PostMapping("/place3")
    public String placeOrder3(@Validated @RequestBody final Order order) {
        return this.orSer.placeOrder3(order);
    }

}
