package com.training.ykb.order.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.training.ykb.order.service.OrderService;

@Configuration
public class OrderConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Qualifier("cos")
    public OrderService createOrderService() {
        return new OrderService();
    }
}
