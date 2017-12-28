package org.kd.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public final class LendingRequestWrapper {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders defaultHeaders;

    private String host;
    private String mainEndpoint;
    private int responseStatusCode;
    private String responseBody;
    private String requestBody;

    private static final Logger logger = LoggerFactory.getLogger(LendingRequestWrapper.class);

    public LendingRequestWrapper(String appName, String mainEndpoint) {
        this.host = ServiceRegistry.getServiceUrl(appName);
        this.mainEndpoint = mainEndpoint;
        logger.info("Created {} for app {} with main endpoint {}", LendingRequestWrapper.class.getSimpleName(), appName, mainEndpoint);
    }

    public void sendRequest(HttpMethod method, String requestBody, String relativeRequestUrl, Map<String, String> headers) {
        String requestUrl = host.concat(mainEndpoint).concat(relativeRequestUrl);
        this.requestBody = requestBody;
        logRequest(method, requestBody, requestUrl);

        try {
            HttpEntity<String> entity = createRequestEntity(requestBody);
            ResponseEntity<String> responseEntity = restTemplate.exchange(requestUrl, method, entity, String.class);

            responseBody = responseEntity.getBody();
            responseStatusCode = responseEntity.getStatusCode().value();
            logResponse();
        } catch (HttpStatusCodeException e) {
            responseBody = e.getResponseBodyAsString();
            responseStatusCode = e.getStatusCode().value();

            logger.error("Exception during ".concat(method.name()).concat("sending to ").concat(requestUrl));
        }
    }

    private HttpEntity<String> createRequestEntity(String request) {
        return new HttpEntity<>(request, defaultHeaders);
    }

    private void logRequest(HttpMethod method, String request, String requestUrl) {
        logger.info("Sending '{}' to url '{}'", method, requestUrl);
        logger.info("Request body: {}", request);
    }

    private void logResponse() {
        logger.info("Response status: {}", responseStatusCode);
    }

    public HttpHeaders getDefaultHeaders() {
        return defaultHeaders;
    }

    public int getResponseStatusCode() {
        return responseStatusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }


}
