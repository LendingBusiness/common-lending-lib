package org.kd.config;

import org.kd.service.LendingRequestWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public final class RequestWrapperConfig {

    @Bean
    public LendingRequestWrapper createDefaultHeaders() {
        return new LendingRequestWrapper();
    }
}
