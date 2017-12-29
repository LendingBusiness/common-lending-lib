package org.kd.service;

public class ServiceRegistry {

    private ServiceRegistry(){

    }

    public static String getServiceUrl(String appName) {
        switch (appName) {
            default:
                return "http://localhost:8090"; //just a stub
        }
    }

    public static int getAppPort(String appName) {
        switch (appName) {
            default:
                return 8090; //stub
        }
    }
}
