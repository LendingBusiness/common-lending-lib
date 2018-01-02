package org.kd.model;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public abstract class LendingRestApp {

    protected static ConfigurableApplicationContext context;

    public static ConfigurableApplicationContext getContext() {
        return context;
    }

    public static void start(Class clazzToStart){
        context = SpringApplication.run(clazzToStart);
    }

    public static void stop(){
        context.stop();
    }

}
