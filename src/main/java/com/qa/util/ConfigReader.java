package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    /**
     * This method is used to load properties from config.properties file
     * @return Properties prop object
     */

    public static Properties initProp() {
        properties = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            try {
                properties.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
