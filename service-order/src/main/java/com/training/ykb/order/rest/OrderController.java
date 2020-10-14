package com.training.ykb.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.order.model.Order;
import com.training.ykb.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    @Qualifier("os")
    private OrderService orSer;

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
