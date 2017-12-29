package org.kd.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Component
public class InputDataProvider {

    @Value("src/test/resources/testdata/")
    private String jsonDirectory;

    private Logger logger = LoggerFactory.getLogger(InputDataProvider.class);

    private ObjectMapper mapper = new ObjectMapper();

    public String getDataByFileName(String fileName) throws IOException {
        return exchangeDataForFileName(fileName, new HashMap<>());
    }

    public <T> T getDataByFileNameAsObject(String fileName, TypeReference valueTypeOf) throws IOException {
        String fileContent = getDataByFileName(fileName);
        return mapper.readValue(fileContent, valueTypeOf);
    }

    public <T> T getDataByFileNameAsObject(String fileName, Class<T> valueType) throws IOException {
        String fileContent = getDataByFileName(fileName);
        return mapper.readValue(fileContent, valueType);
    }

    public String exchangeDataForFileName(String fileName, Map<String, String> exchangeData) throws IOException {
        return exchangeDataForFullPathFile(jsonDirectory.concat(fileName), exchangeData);
    }

    public String exchangeDataForFullPathFile(String fullPath, Map<String, String> exchangeData) throws IOException {
        try {
            Path path = Paths.get(fullPath);
            String inputData = new String(Files.readAllBytes(path));
            for (Map.Entry<String, String> entry : exchangeData.entrySet()){
                inputData = replaceFieldInJsonFile(inputData, entry.getKey(), entry.getValue());
            }
            return inputData;
        }
        catch (IOException e){
            logger.error("Error while reading from file ".concat(fullPath), e);
            throw e;
        }
    }

    private String replaceFieldInJsonFile(String jsonFileString, String key, String value) {
        return jsonFileString.replace(key, value);
    }

    public String getJsonDirectory() {
        return jsonDirectory;
    }
}
