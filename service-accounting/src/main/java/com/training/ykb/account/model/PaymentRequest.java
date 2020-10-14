package com.training.ykb.account.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class PaymentRequest {

    @NotNull
    private Long orderId;
    @NotNull
    private Long customerId;
    @Max(100_000)
    private int  amount;

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final Long orderIdParam) {
        this.orderId = orderIdParam;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final Long customerIdParam) {
        this.customerId = customerIdParam;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(final int amountParam) {
        this.amount = amountParam;
    }


}
