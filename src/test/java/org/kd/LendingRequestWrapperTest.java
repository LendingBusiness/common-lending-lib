package org.kd;

import org.junit.Test;
import org.kd.service.LendingRequestWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LendingRequestWrapperTest {

    @Test
    public void testSend(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(LendingRequestWrapper.class);

    }
}
