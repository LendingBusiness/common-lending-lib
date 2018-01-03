package org.kd;

import org.kd.model.LendingRestApp;
import org.kd.service.ServiceRegistry;

public class TestPartyMgmtApp extends LendingRestApp{

    private TestPartyMgmtApp(){
        appName = ServiceRegistry.AppName.PARTY_MANAGEMENT;
    }

}
