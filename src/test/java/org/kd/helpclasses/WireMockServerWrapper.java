package org.kd.helpclasses;

import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.any;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class WireMockServerWrapper {

    private static WireMockServer server;

    public final static void start(int port) {
        server = new WireMockServer(port);
        server.start();
        server.stubFor(any(urlEqualTo("/some/thing"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("Hello world!")));
    }

    public final static void stop(){
        server.stop();
    }
}
