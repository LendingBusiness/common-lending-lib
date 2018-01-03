package org.kd;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.helpclasses.WireMockServerWrapper;
import org.kd.service.LendingRequestWrapper;
import org.kd.service.ServiceRegistry;
import org.kd.testconfig.TestAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.kd.service.ServiceRegistry.AppName;
import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackageClasses = {TestAppConfig.class})
public class LendingRequestWrapperTest {

    //@Value("${server.port}")
    private String serverPort = "8080";
    //@Value("${server.host}")
    private String host = "localhost";

    private LendingRequestWrapper wrapper;

    @Before
    public void setup() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(TestAppConfig.class);
        wrapper = ctx.getBean(LendingRequestWrapper.class);
    }

    @Test
    public void testInitialization() {
        notNull(wrapper, "Wrapper not initialized with bean");
    }

    @Test
    public void testReturnedValue() {
        String port = AppName.PARTY_MANAGEMENT.getPort();
        WireMockServerWrapper.start(Integer.parseInt(port));
        wrapper.sendRequest(HttpMethod.GET, "", "");
        WireMockServerWrapper.stop();

        isTrue(wrapper.getResponseStatusCode() == HttpStatus.OK.value()
                , "Wrong http status returned = " + wrapper.getResponseStatusCode());
        isTrue("Hello world!".equals(wrapper.getResponseBody())
                , "Expected response from wiremock not received");
    }

    @Test
    public void testGetMethod() {
        String port = AppName.PARTY_MANAGEMENT.getPort();
        WireMockServerWrapper.start(Integer.parseInt(port));
        wrapper.setMainEndpoint("/hello");
        wrapper.sendRequest(HttpMethod.GET, "", "/?param1=value1");
        WireMockServerWrapper.stop();

        isTrue(wrapper.getResponseStatusCode() == HttpStatus.OK.value()
                , "Wrong http status returned = " + wrapper.getResponseStatusCode());
        isTrue("A parameter value1 was passed".equals(wrapper.getResponseBody())
                , "Expected response from wiremock not received");
    }
}
