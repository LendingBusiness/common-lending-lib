package org.kd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.config.AppConfig;
import org.kd.service.LendingRequestWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.util.Assert.notNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackageClasses = AppConfig.class)
public final class LendingRequestWrapperTest {

    //@Value("${server.port}")
    private String serverPort = "8080";
    //@Value("${server.host}")
    private String host = "localhost";

    @Test
    public void testSend() {
        ApplicationContext ctx
                = new AnnotationConfigApplicationContext(AppConfig.class);
        LendingRequestWrapper wrapper = ctx.getBean(LendingRequestWrapper.class);

        notNull(wrapper, "Wrapper not initialized with bean");
    }
}
