package org.kd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.config.RequestWrapperConfig;
import org.kd.config.RestTemplateConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.springframework.util.Assert.notNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackageClasses = RestTemplateConfig.class)
public final class DefaultRestTemplateTest {

    @Test
    public void createDefaultRestTemplateTest() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(RequestWrapperConfig.class);
        RestTemplate restTemplate = ctx.getBean(RestTemplate.class);

        notNull(restTemplate, "Rest Template from Bean is null");
    }
}
