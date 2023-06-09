package com.test.hook;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.test.config.WinAppDriverConfig.getWindowsDriver;
import static com.test.util.Util.getAppData;

/**
 * The Hook class provides setup and teardown methods for the Cucumber hooks in the test scenarios.
 * It initializes the WebDriver and WindowsDriver instances, performs necessary configurations, and handles cleanup after the tests.
 */
public class Hook {
    private final String BASE_URL = "https://www.ccleaner.com/";
    private WindowsDriver desktopSession;

    /**
     * Sets up the WebDriver and initializes the necessary configurations before the download-related scenarios.
     * It sets the browser to Chrome, configures browser size and timeouts, and sets the downloads folder location.
     * It also opens the base URL.
     */
    @Before("@download")
    public void initDriver() {
        Configuration.browser = "chrome";
        new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 20000;
        Configuration.pageLoadTimeout = 20000;
        Configuration.downloadsFolder = System.getProperty("user.dir").replace('\\', '/') + "/target";
        open(BASE_URL);
    }

    /**
     * Sets up the WindowsDriver and initializes the necessary configurations before the install-related scenarios.
     * It retrieves the WindowsDriver instance, executes a PowerShell script to start the installation process,
     * and waits for a specified duration.
     */
    @Before("@install")
    public void initWinAppDriver() {
        desktopSession = getWindowsDriver();
        String script = "Start-Process -FilePath " + getAppData("pathToFile") + " ";
        desktopSession.executeScript("powerShell", ImmutableMap.of("script", script));
        sleep(15000);
    }

    /**
     * Tears down and closes the WebDriver after the download-related scenarios.
     */
    @After("@download")
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    /**
     * Tears down and quits the WindowsDriver after the install-related scenarios.
     */
    @After("@install")
    public void tearDownWinAppDriver() {
        desktopSession.quit();
    }
}
