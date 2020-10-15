package com.training.ykb.account.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.training.ykb.account.model.PaymentRequest;


@Service
public class PaymentService {

    @Value("${server.port}")
    private int port;

    public String pay(final PaymentRequest pr) {
        if (pr.getOrderId() == 300) {
            throw new IllegalArgumentException("Error 300");
        }
        return "OK-" + this.port;
    }

}
