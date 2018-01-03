package org.kd;


import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.kd.service.ServiceRegistry.AppName;

public class AppNameTest {

    @Test
    public void testAppName() {
        AppName appName = AppName.FUND_MANAGEMENT;
        assertNotNull(appName.getPort());
    }
}
