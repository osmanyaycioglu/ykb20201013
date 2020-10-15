package com.training.ykb;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify_q", durable = "yes", autoDelete = "false"),
                                             exchange = @Exchange(name = "notify_exc",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notify_q_key"))
    @SendTo("order_exc/notify_response")
    public String handleXYZ(final Order order) {
        System.out.println("Incoming event : " + order);
        return "Order " + order.getOrderId() + " processed";
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify_q_2", durable = "yes", autoDelete = "false"),
                                             exchange = @Exchange(name = "notify_exc",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notify_q_key_2"))
    public void handleXYZ2(final Order order) {
        System.out.println("Incoming event 2 : " + order);
    }

}
