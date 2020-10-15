package com.training.ykb.order.rest;

import java.util.ArrayList;
import java.util.List;

public class ErrorObject {

    private List<ErrorObject> childErrors;

    private String            errorDesc;
    private int               errorCause;
    private String            subDomain;
    private String            boundedContext;
    private String            microservice;


    public void addChild(final ErrorObject errorObjectParam) {
        if (this.getChildErrors() == null) {
            this.childErrors = new ArrayList<>();
        }
        this.getChildErrors()
            .add(errorObjectParam);
    }

    public List<ErrorObject> getChildErrors() {
        return this.childErrors;
    }


    public String getErrorDesc() {
        return this.errorDesc;
    }


    public void setErrorDesc(final String errorDescParam) {
        this.errorDesc = errorDescParam;
    }


    public int getErrorCause() {
        return this.errorCause;
    }


    public void setErrorCause(final int errorCauseParam) {
        this.errorCause = errorCauseParam;
    }


    public String getSubDomain() {
        return this.subDomain;
    }


    public void setSubDomain(final String subDomainParam) {
        this.subDomain = subDomainParam;
    }


    public String getBoundedContext() {
        return this.boundedContext;
    }


    public void setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
    }


    public String getMicroservice() {
        return this.microservice;
    }


    public void setMicroservice(final String microserviceParam) {
        this.microservice = microserviceParam;
    }


    public void setChildErrors(final List<ErrorObject> childErrorsParam) {
        this.childErrors = childErrorsParam;
    }

    @Override
    public String toString() {
        return "ErrorObject [childErrors="
               + this.childErrors
               + ", errorDesc="
               + this.errorDesc
               + ", errorCause="
               + this.errorCause
               + ", subDomain="
               + this.subDomain
               + ", boundedContext="
               + this.boundedContext
               + ", microservice="
               + this.microservice
               + "]";
    }


}
