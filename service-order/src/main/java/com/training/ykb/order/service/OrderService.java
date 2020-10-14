package com.training.ykb.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.training.ykb.order.model.Order;
import com.training.ykb.order.model.PaymentRequest;
import com.training.ykb.order.rest.clients.IAccountClient;

@Service
@Qualifier("os")
public class OrderService {

    @Autowired
    private RestTemplate   rt;

    @Autowired
    private EurekaClient   eClient;

    @Autowired
    private IAccountClient accountClient;


    public String placeOrder3(final Order orderParam) {
        PaymentRequest paymentRequestLoc = new PaymentRequest();
        paymentRequestLoc.setCustomerId(orderParam.getCustomerId());
        paymentRequestLoc.setOrderId(orderParam.getOrderId());
        paymentRequestLoc.setAmount(100);
        return this.accountClient.pay(paymentRequestLoc);
    }

    public String placeOrder(final Order orderParam) {
        PaymentRequest paymentRequestLoc = new PaymentRequest();
        paymentRequestLoc.setCustomerId(orderParam.getCustomerId());
        paymentRequestLoc.setOrderId(orderParam.getOrderId());
        paymentRequestLoc.setAmount(100);
        String postForObjectLoc = this.rt.postForObject("http://ACCOUNTING/account/pay",
                                                        paymentRequestLoc,
                                                        String.class);
        return postForObjectLoc;
    }

    public String placeOrder2(final Order orderParam) {
        PaymentRequest paymentRequestLoc = new PaymentRequest();
        paymentRequestLoc.setCustomerId(orderParam.getCustomerId());
        paymentRequestLoc.setOrderId(orderParam.getOrderId());
        paymentRequestLoc.setAmount(100);
        RestTemplate restTemplateLoc = new RestTemplate();

        List<InstanceInfo> instancesLoc = this.eClient.getApplication("ACCOUNTING")
                                                      .getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println("" + instanceInfoLoc);
        }

        InstanceInfo in = this.eClient.getNextServerFromEureka("ACCOUNTING",
                                                               false);


        String postForObjectLoc = restTemplateLoc.postForObject("http://"
                                                                + in.getIPAddr()
                                                                + ":"
                                                                + in.getPort()
                                                                + "/account/pay",
                                                                paymentRequestLoc,
                                                                String.class);
        return postForObjectLoc;
    }


}
