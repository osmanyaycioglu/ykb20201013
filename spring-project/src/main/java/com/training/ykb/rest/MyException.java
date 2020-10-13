package com.training.ykb.rest;


public class MyException extends Exception {

    private String desc;
    private int    myCause;

    public MyException(final String descParam,
                       final int myCauseParam) {
        super();
        this.desc = descParam;
        this.myCause = myCauseParam;
    }

    public MyException() {
    }


    public String getDesc() {
        return this.desc;
    }


    public int getMyCause() {
        return this.myCause;
    }


}
