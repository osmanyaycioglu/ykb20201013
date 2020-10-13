package com.training.ykb;

import org.springframework.stereotype.Component;

@Component
public class MyFirstObject {

    private String str;


    public void hello() {
        System.out.println("Hello " + this.str);
    }


    public String getStr() {
        return this.str;
    }


    public void setStr(final String strParam) {
        this.str = strParam;
    }


}
