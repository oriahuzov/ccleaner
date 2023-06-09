package com.test.config;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.options.WindowsOptions;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * The WinAppDriverConfig class provides configuration and access to the WindowsDriver instance for automated testing of Windows applications.
 */
public class WinAppDriverConfig {
    private static WindowsDriver instance;

    private WinAppDriverConfig() {
    }

    /**
     * Returns the singleton instance of the WindowsDriver.
     *
     * @return the WindowsDriver instance
     */
    public static WindowsDriver getWindowsDriver() {
        if (instance == null) {
            instance = createWindowsDriver();
        }
        return instance;
    }

    /**
     * Creates and returns a new WindowsDriver instance.
     *
     * @return the newly created WindowsDriver instance
     * @throws RuntimeException if an error occurs during the creation of the WindowsDriver instance
     */
    private static WindowsDriver createWindowsDriver() {
        WindowsOptions options = createWindowsOptions();
        try {
            return new WindowsDriver(new URL("http://0.0.0.0:4723/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates and returns a new WindowsOptions instance.
     *
     * @return the newly created WindowsOptions instance
     */
    private static WindowsOptions createWindowsOptions() {
        WindowsOptions options = new WindowsOptions();
        options.setApp("Root");
        options.setPlatformName("windows");
        options.setAutomationName("windows");
        return options;
    }
}
