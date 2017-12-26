package org.kd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.config.HeadersConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultHeadersTest {

    @Test
    public void testHeadersCreation() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HeadersConfig.class);
        HttpHeaders headers = ctx.getBean(HttpHeaders.class);

        notNull(headers, "Headers null");
        isTrue(!headers.isEmpty(), "Empty headers");
    }
}
