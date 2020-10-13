package com.training.ykb;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class Runner {

    public static void main(final String[] args) {
        ConfigurableApplicationContext appContext = SpringApplication.run(SpringProjectApplication.class,
                                                                          args);
        //        MyFirstObject firstObjectLoc = new MyFirstObject();
        //        firstObjectLoc.setStr("osman");
        //        firstObjectLoc.hello();
        SpringProjectApplication beanLoc = appContext.getBean(SpringProjectApplication.class);
        beanLoc.getFirstObject()
               .setStr("osman");
        beanLoc.getFirstObject()
               .hello();

    }
}
