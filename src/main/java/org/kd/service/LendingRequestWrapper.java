package org.kd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

public class LendingRequestWrapper {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders headers;

    private int responseCode;
    private String responseBody;
    private String responseHeader;

    private final static Logger logger = Logger.getLogger(LendingRequestWrapper.class.getName());

    public void send(String host, String endPoint, HttpMethod method) {
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        restTemplate.exchange(host.concat(endPoint), method, entity, String.class);
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public String getResponseHeader() {
        return responseHeader;
    }
}
