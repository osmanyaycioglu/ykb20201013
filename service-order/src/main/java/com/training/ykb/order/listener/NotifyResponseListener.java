package com.training.ykb.order.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotifyResponseListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify_response_q",
                                                            durable = "yes",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "order_exc",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notify_response"))
    public void handleResponse(final String orderResponse) {
        System.out.println("Order Response : " + orderResponse);
    }

}
