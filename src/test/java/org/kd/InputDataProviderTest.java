package org.kd;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.config.AppConfig;
import org.kd.helpclasses.JsonFileContent;
import org.kd.service.InputDataProvider;
import org.kd.service.LendingRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.util.Assert.isTrue;

@RunWith(SpringJUnit4ClassRunner.class)
public class InputDataProviderTest {

    private static final Logger logger = LoggerFactory.getLogger(LendingRequestWrapper.class);
    private InputDataProvider testInputDataProvider;

    @Before
    public void setup(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        testInputDataProvider = ctx.getBean(InputDataProvider.class);
    }

    @Test
    public void testJsonReading() {
        try {
            String jsonContent = testInputDataProvider.getDataByFileName("data.json");
            isTrue(jsonContent.contains("key1"), "'key1' not found.");
            isTrue(jsonContent.contains("key2"), "'key2' not found.");
            isTrue(jsonContent.contains("key3"), "'key3' not found.");
            isTrue(jsonContent.contains("value1"), "'value1' not found.");
            isTrue(jsonContent.contains("value2"), "'value2' not found.");
            isTrue(jsonContent.contains("value3"), "'value3' not found.");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void testExchangeDataForFileName(){
        try{
            Map<String, String> changeMap = new HashMap<>();
            changeMap.put("value1", "valueA");
            changeMap.put("value3", "valueC");
            String jsonContent = testInputDataProvider.exchangeDataForFileName("data.json", changeMap);

            isTrue(jsonContent.contains("key1\" : \"valueA"), "exchange error");
            isTrue(jsonContent.contains("key2\" : \"value2"), "reading error");
            isTrue(jsonContent.contains("key3\" : \"valueC"), "exchange error");
        }
        catch (IOException e){
            logger.error(e.getMessage());
        }
    }

    @Test
    public void testGetDataByFileNameAsObject(){
        try {
            JsonFileContent jsonFileContent = testInputDataProvider.getDataByFileNameAsObject("data.json", JsonFileContent.class);
            isTrue(jsonFileContent.key1.contains("value1"), "mapping error");
            isTrue(jsonFileContent.key2.contains("value2"), "mapping error");
            isTrue(jsonFileContent.key3.contains("value3"), "mapping error");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
