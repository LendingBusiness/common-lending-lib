package org.kd.config;

import org.kd.service.InputDataProvider;
import org.kd.service.LendingRequestWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public LendingRequestWrapper getLendingRequestWrapper() {
        return new LendingRequestWrapper("testApp", "testEndpoint");
    }

    @Value("${server.port}")
    private String serverPort;
    @Value("${server.host}")
    private String host;

    @Bean
    public RestTemplate createDefaultRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.rootUri(host.concat(":").concat(serverPort)).build();
    }

    @Bean(name = "restTemplateBuilder")
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder();
    }

    @Bean
    public HttpHeaders getDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
    }

    @Bean
    public InputDataProvider createInputDataProvider(){
        return new InputDataProvider();
    }
}
