package com.training.ykb.account.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleException(final Exception exceptionParam) {
        ErrorObject errorObjectLoc = new ErrorObject();
        errorObjectLoc.setBoundedContext("IT-CRM");
        errorObjectLoc.setSubDomain("IT");
        errorObjectLoc.setMicroservice("Spring proj");
        errorObjectLoc.setErrorDesc(exceptionParam.getMessage());
        errorObjectLoc.setErrorCause(1001);
        return errorObjectLoc;
    }
}
