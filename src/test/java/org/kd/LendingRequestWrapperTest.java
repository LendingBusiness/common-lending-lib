package org.kd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.config.RequestWrapperConfig;
import org.kd.service.LendingRequestWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackageClasses = RequestWrapperConfig.class)
public final class LendingRequestWrapperTest {

    @Value("${server.port}")
    private String serverPort;
    @Value("${server.host}")
    private String host;

    @Test
    public void testSend() {
        ApplicationContext ctx
                = new AnnotationConfigApplicationContext(RequestWrapperConfig.class);
        LendingRequestWrapper wrapper = ctx.getBean(LendingRequestWrapper.class);
        wrapper.send(host.concat(":".concat(serverPort)), "/none", HttpMethod.GET);
    }
}
