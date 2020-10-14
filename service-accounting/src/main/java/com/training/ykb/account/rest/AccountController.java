package com.training.ykb.account.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.account.model.PaymentRequest;
import com.training.ykb.account.service.PaymentService;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private PaymentService ps;

    @PostMapping("/pay")
    public String pay(@Validated @RequestBody final PaymentRequest payment) {
        return this.ps.pay(payment);
    }
}
