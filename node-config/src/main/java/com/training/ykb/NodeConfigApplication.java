package com.training.ykb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@EnableConfigServer
public class NodeConfigApplication {

    @Scheduled(fixedDelay = 10_000, initialDelay = 10)
    public void name() {
        System.out.println("osman");
    }

    public static void main(final String[] args) {
        SpringApplication.run(NodeConfigApplication.class,
                              args);
    }

}
