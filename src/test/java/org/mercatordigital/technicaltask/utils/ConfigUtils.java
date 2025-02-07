package org.mercatordigital.technicaltask.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {

    private final Properties properties;

    public ConfigUtils() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration file");
        }
    }

    public String getProperty(String key) {

        return properties.getProperty(key);
    }
}
