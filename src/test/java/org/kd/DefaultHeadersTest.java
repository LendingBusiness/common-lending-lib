package org.kd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.service.LendingRequestWrapper;
import org.kd.testconfig.TestAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

@RunWith(SpringJUnit4ClassRunner.class)
public final class DefaultHeadersTest {

    @Test
    public void testHeadersCreation() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(TestAppConfig.class);
        ctx.refresh();

        LendingRequestWrapper wrapper = ctx.getBean(LendingRequestWrapper.class);

        notNull(wrapper.getDefaultHeaders(), "Headers null");
        isTrue(!wrapper.getDefaultHeaders().isEmpty(), "Empty headers");
    }
}
