package org.kd;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.config.AppConfig;
import org.kd.helpclasses.WireMockServerWrapper;
import org.kd.service.LendingRequestWrapper;
import org.kd.service.ServiceRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackageClasses = AppConfig.class)
public class LendingRequestWrapperTest {

    //@Value("${server.port}")
    private String serverPort = "8080";
    //@Value("${server.host}")
    private String host = "localhost";

    private LendingRequestWrapper wrapper;

    @Before
    public void setup() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        wrapper = ctx.getBean(LendingRequestWrapper.class);
    }

    @Test
    public void testInitialization() {
        notNull(wrapper, "Wrapper not initialized with bean");
    }

    @Test
    public void testReturnedValue() {
        int port = ServiceRegistry.getPort("app");
        WireMockServerWrapper.start(port);
        wrapper.sendRequest(HttpMethod.GET, "", "");
        WireMockServerWrapper.stop();
        isTrue(wrapper.getResponseStatusCode() == 200, "Wrong http status returned = " + wrapper.getResponseStatusCode());
        isTrue(wrapper.getResponseBody().equals("Hello world!"), "Expected response from wiremock not received");
    }
}
