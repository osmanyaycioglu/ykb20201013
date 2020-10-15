package com.training.ykb.order.config;

import com.training.ykb.order.rest.ErrorObject;

public class MyException extends Exception {

    private static final long serialVersionUID = -6515566548032873323L;
    private final ErrorObject errorObject;

    public MyException(final ErrorObject errorObjectParam) {
        this.errorObject = errorObjectParam;
    }

    public ErrorObject getErrorObject() {
        return errorObject;
    }
}
