package org.kd.model;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import static org.kd.service.ServiceRegistry.AppName;

public abstract class LendingRestApp {

    protected static AppName appName;

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
