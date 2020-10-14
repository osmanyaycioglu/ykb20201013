package com.training.ykb.order.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Order {

    @NotNull
    private Long         customerId;
    @NotNull
    private Long         orderId;
    @NotNull
    @Size(min = 1)
    private List<String> orderedItem;

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final Long customerIdParam) {
        this.customerId = customerIdParam;
    }

    public List<String> getOrderedItem() {
        return this.orderedItem;
    }

    public void setOrderedItem(final List<String> orderedItemParam) {
        this.orderedItem = orderedItemParam;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final Long orderIdParam) {
        this.orderId = orderIdParam;
    }


}
