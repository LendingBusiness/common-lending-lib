package org.kd.service;

public class ServiceRegistry {

    private ServiceRegistry() {
    }

    public static String getServiceUrl(AppName appName) {
        switch (appName) {
            default:
                return "http://localhost:".concat(appName.getPort()); //just a stub
        }
    }

    public enum AppName {
        PARTY_MANAGEMENT, FUND_MANAGEMENT, TRADE;

        public String getPort() {
            switch (this) {
                case PARTY_MANAGEMENT:
                    return "8091";
                case FUND_MANAGEMENT:
                    return "8092";
                default:
                    return "8093";
            }
        }
    }
}
