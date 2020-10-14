package com.training.ykb.order.rest.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.ykb.order.model.PaymentRequest;

@FeignClient("ACCOUNTING")
@RequestMapping("/account")
public interface IAccountClient {

    @PostMapping("/pay")
    public String pay(@RequestBody final PaymentRequest payment);

}
