package com.training.ykb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Configuration
//@Controller
//@Repository
//@Service
public class SpringProjectApplication {

    @Autowired
    private MyFirstObject firstObject;


    public MyFirstObject getFirstObject() {
        return this.firstObject;
    }

    public void setFirstObject(final MyFirstObject firstObjectParam) {
        this.firstObject = firstObjectParam;
    }

}
