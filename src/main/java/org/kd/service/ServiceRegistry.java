package org.kd.service;

public class ServiceRegistry {

    static String getServiceUrl(String appName){
        return "http://localhost:8090"; //just a stub
    }

    public static int getPort(String appName){
        return 8090;//stub
    }
}
