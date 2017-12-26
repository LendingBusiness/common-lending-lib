package org.kd.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

public class LendingRequestWrapper{

    @Autowired
    private RestTemplate restTemplate;

    private int responseCode;
    private String responseBody;
    private String responseHeader;

    private final static Logger logger = Logger.getLogger(LendingRequestWrapper.class.getName());

    public void send(String host, String endPoint, HttpMethod method){
        try {
            RequestEntity<String> requestEntity = new RequestEntity<>(method, new URI(host.concat(endPoint)));
            restTemplate.exchange(host.concat(endPoint), method, requestEntity, String.class);
        }
        catch (URISyntaxException e)
        {
            logger.warning("wrong uri: ".concat(host).concat(endPoint));
        }


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
