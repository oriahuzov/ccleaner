package com.test.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * The Util class provides utility methods for managing application data.
 * It includes methods to set and retrieve key-value pairs in a properties file.
 */
public class Util {

    private Util() {
    }

    /**
     * Sets the value for a specified key in the properties file.
     *
     * @param key   The key to set.
     * @param value The value to set for the key.
     */
    public static void setAppData(String key, String value) {
        String pathToAppData = "src/test/resources/app_data.properties";
        Properties prop = new Properties();
        try {
            Path path = Paths.get(pathToAppData);
            InputStream in = Files.newInputStream(path);
            prop.load(in);
            prop.setProperty(key, value);
            prop.store(Files.newOutputStream(path), null);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the value associated with a specified key from the properties file.
     *
     * @param key The key to retrieve the value for.
     * @return The value associated with the key, or an empty string if the key is not found.
     */
    public static String getAppData(String key) {
        String value = "";
        try {
            String pathToAppData = "src/test/resources/app_data.properties";
            FileInputStream fileInputStream;
            Properties config = new Properties();
            fileInputStream = new FileInputStream(pathToAppData);
            config.load(fileInputStream);
            value = config.getProperty(key);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
