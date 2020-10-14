package com.training.ykb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.training.ykb.order.config.AccountingRibbonConfig;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RibbonClient(name = "ACCOUNTING", configuration = AccountingRibbonConfig.class)
public class ServiceOrderApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ServiceOrderApplication.class,
                              args);
    }

}
