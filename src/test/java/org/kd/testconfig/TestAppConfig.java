package org.kd.testconfig;

import org.kd.config.AppConfig;
import org.kd.service.LendingRequestWrapper;
import static org.kd.service.ServiceRegistry.AppName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestAppConfig extends AppConfig {

    @Bean(name = "testLendingRequestWrapper")
    public LendingRequestWrapper createTestLendingRequestWrapper() {
        return new LendingRequestWrapper(AppName.PARTY_MANAGEMENT, "/hello/world");
    }

}
