package com.training.ykb.account.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.training.ykb.account.model.PaymentRequest;


@Service
public class PaymentService {

    @Value("${server.port}")
    private int port;

    public String pay(final PaymentRequest pr) {
        return "OK-" + this.port;
    }

}
