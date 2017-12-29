package org.kd.testconfig;

import org.kd.config.AppConfig;
import org.kd.service.LendingRequestWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestAppConfig extends AppConfig {

    @Bean(name = "testLendingRequestWrapper")
    public LendingRequestWrapper createTestLendingRequestWrapper() {
        return new LendingRequestWrapper("testApp", "/hello/world");
    }

}
