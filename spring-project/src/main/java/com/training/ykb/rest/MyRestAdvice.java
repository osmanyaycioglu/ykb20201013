package com.training.ykb.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyRestAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleIllegalArgumentException(final IllegalArgumentException exceptionParam) {
        ErrorObject errorObjectLoc = new ErrorObject();
        errorObjectLoc.setBoundedContext("IT-CRM");
        errorObjectLoc.setSubDomain("IT");
        errorObjectLoc.setMicroservice("Spring proj");
        errorObjectLoc.setErrorDesc(exceptionParam.getMessage());
        errorObjectLoc.setErrorCause(1001);
        return errorObjectLoc;
    }

    @ExceptionHandler(MyException.class)
    public ResponseEntity<ErrorObject> handleMyException(final MyException exceptionParam) {
        ErrorObject errorObjectLoc = new ErrorObject();
        errorObjectLoc.setBoundedContext("IT-CRM");
        errorObjectLoc.setSubDomain("IT");
        errorObjectLoc.setMicroservice("Spring proj");
        errorObjectLoc.setErrorDesc(exceptionParam.getMessage());
        errorObjectLoc.setErrorCause(1001);
        if (exceptionParam.getMyCause() > 100) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                                 .body(errorObjectLoc);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(errorObjectLoc);
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleMethodArgumentNotValidException(final MethodArgumentNotValidException exceptionParam) {
        ErrorObject errorObjectLoc = new ErrorObject();
        errorObjectLoc.setBoundedContext("IT-CRM");
        errorObjectLoc.setSubDomain("IT");
        errorObjectLoc.setMicroservice("Spring proj");
        errorObjectLoc.setErrorDesc("Validation Error");
        errorObjectLoc.setErrorCause(1001);
        List<ObjectError> allErrorsLoc = exceptionParam.getBindingResult()
                                                       .getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            ErrorObject c = new ErrorObject();
            c.setBoundedContext("IT-CRM");
            c.setSubDomain("IT");
            c.setMicroservice("Spring proj");
            c.setErrorDesc(objectErrorLoc.toString());
            c.setErrorCause(1001);
            errorObjectLoc.addChild(c);
        }
        return errorObjectLoc;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObject handleError(final Exception exceptionParam) {
        ErrorObject errorObjectLoc = new ErrorObject();
        errorObjectLoc.setBoundedContext("IT-CRM");
        errorObjectLoc.setSubDomain("IT");
        errorObjectLoc.setMicroservice("Spring proj");
        errorObjectLoc.setErrorDesc(exceptionParam.getMessage());
        errorObjectLoc.setErrorCause(1001);
        return errorObjectLoc;
    }

}
