package com.training.ykb.order.config;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.ykb.order.rest.ErrorObject;

import feign.Response;
import feign.Response.Body;
import feign.codec.ErrorDecoder;

@Component
public class MyErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(final String methodKeyParam,
                            final Response responseParam) {
        try {
            if (responseParam.status() != 404) {
                Body bodyLoc = responseParam.body();
                ObjectMapper objectMapper = new ObjectMapper();
                ErrorObject readValueLoc = objectMapper.readValue(bodyLoc.asInputStream(),
                                                                  ErrorObject.class);
                MyException exceptionLoc = new MyException(readValueLoc);
                return exceptionLoc;
            }
        } catch (Exception eLoc) {
            ErrorObject errorObjectLoc = new ErrorObject();
            errorObjectLoc.setErrorDesc("Internal Error");
            MyException exceptionLoc = new MyException(errorObjectLoc);
            return exceptionLoc;
        }
        ErrorObject errorObjectLoc = new ErrorObject();
        errorObjectLoc.setErrorDesc("Not Found");
        MyException exceptionLoc = new MyException(errorObjectLoc);
        return exceptionLoc;
    }

}
