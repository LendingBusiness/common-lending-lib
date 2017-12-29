package org.kd.helpclasses;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import org.springframework.http.HttpStatus;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WireMockServerWrapper {

    private static WireMockServer server;

    public static void start(int port) {
        server = new WireMockServer(port);
        server.start();

        server.stubFor(any(urlEqualTo("/hello/world"))
                .willReturn(helloWorldResponse()));

        server.stubFor(get(urlEqualTo("/hello/?param1=value1"))
                .willReturn(paramResponse("value1")));
    }

    public static void stop() {
        server.stop();
    }

    private static ResponseDefinitionBuilder helloWorldResponse() {
        return aResponse()
                .withStatus(HttpStatus.OK.value())
                .withHeader("Content-Type", "text/plain")
                .withBody("Hello world!");
    }

    private static ResponseDefinitionBuilder paramResponse(String value) {
        return aResponse()
                .withStatus(HttpStatus.OK.value())
                .withHeader("Content-Type", "text/plain")
                .withBody("A parameter ".concat(value).concat(" was passed"));
    }


}
