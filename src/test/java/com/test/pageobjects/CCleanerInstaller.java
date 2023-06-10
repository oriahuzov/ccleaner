package com.test.pageobjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import static com.codeborne.selenide.Selenide.sleep;
import static com.test.config.WinAppDriverConfig.getWindowsDriver;

/**
 * The CCleanerInstaller class represents an installer for the CCleaner application.
 * It provides methods to perform various installation-related actions and verify guidelines.
 */
public class CCleanerInstaller {

    public CCleanerInstaller() {
    }

    /**
     * Checks if the CCleaner installer is opened.
     */
    public void ccleanerInstallerIsOpened() {
        WebElement ccleanerApp = findElementByName("CCleaner v6.12 Setup");
        isElementDisplayed(ccleanerApp);
    }

    /**
     * Checks guideline ACR-065 by verifying the display of the license agreement and privacy policy links.
     */
    public void checkGuidelineACR065() {
        WebElement licenseAgreementLink = findElementByName("View License Agreement");
        WebElement privacyPolicyLink = findElementByName("View Privacy Policy");

        boolean result = isElementDisplayed(licenseAgreementLink) && isElementDisplayed(privacyPolicyLink);
        generateTestResult(result, "ACR-065");
    }

    /**
     * Checks guideline ACR-040 by performing actions related to the installation location and verifying the result.
     */
    public void checkGuidelineACR040() {
        WebElement customizeButton = findElementByName("Customize");
        customizeButton.click();

        WebElement moreButton = findElementByName("More");
        moreButton.click();

        WebElement installLocation = findElementByClassName("Edit");
        boolean result = installLocation.getAttribute("Value.Value").equalsIgnoreCase("C:\\Program Files\\CCleaner");
        generateTestResult(result, "ACR-040");

        WebElement backButton = findElementByName("Back");
        backButton.click();
    }

    /**
     * Checks guideline ACR-046 by performing actions related to various options and verifying the result.
     */
    public void checkGuidelineACR046() {
        WebElement addDesktopShortcut = findElementByName("Add Desktop Shortcut");
        addDesktopShortcut.click();

        WebElement addStartMenuShortcuts = findElementByName("Add Start Menu Shortcuts");
        addStartMenuShortcuts.click();

        WebElement addRunCCleanerOptionToRecycleBin = findElementByName("Add 'Run CCleaner' option to Recycle Bin context menu");
        addRunCCleanerOptionToRecycleBin.click();

        WebElement addOpenCCleanerOptionToRecycleBin = findElementByName("Add 'Open CCleaner...' option to Recycle Bin context menu");
        addOpenCCleanerOptionToRecycleBin.click();

        WebElement enableIntelligentCookieScan = findElementByName("Enable Intelligent Cookie Scan");
        enableIntelligentCookieScan.click();

        boolean result = isElementDisplayed(addDesktopShortcut) && isElementDisplayed(addStartMenuShortcuts)
                && isElementDisplayed(addRunCCleanerOptionToRecycleBin) && isElementDisplayed(addOpenCCleanerOptionToRecycleBin)
                && isElementDisplayed(enableIntelligentCookieScan);

        generateTestResult(result, "ACR-046");
        WebElement backButton = findElementByName("Back");
        backButton.click();
    }

    /**
     * Checks guideline ACR-055 by attempting to find the "Cancel" element and generates the test result accordingly.
     */
    public void checkGuidelineACR055() {
        try {
            // should always throw an exception
            findElementByName("Cancel");
        } catch (NoSuchElementException e) {
            generateTestResult(false, "ACR-055");
        }
    }

    /**
     * Installs and runs the CCleaner app.
     */
    public void installAndRunApp() {
        WebElement installButton = findElementByName("Install");
        installButton.click();
        sleep(15000);

        WebElement viewReleasesNoteCheckbox = findElementByName("View release notes");
        viewReleasesNoteCheckbox.click();

        WebElement runAppButton = findElementByName("Run CCleaner");
        runAppButton.click();
    }

    /**
     * Generates the test result based on the provided boolean result and guideline ID.
     *
     * @param result      the result of the test
     * @param guidelineId the ID of the guideline being tested
     */
    private void generateTestResult(boolean result, String guidelineId) {
        String resultText = (result) ? "OK" : "NOT OK";
        String screenshotPath = "target\\screen_" + guidelineId + ".png";
        String absolutePathToFile = saveScreenshot(screenshotPath);

        String reportText = guidelineId + " - " + resultText + "\n" +
                "Screenshot: " + absolutePathToFile + "\n";
        appendReport(reportText);
    }

    /**
     * Finds an element by its name.
     *
     * @param name the name of the element
     * @return the WebElement representing the found element
     */
    private WebElement findElementByName(String name) {
        return getWindowsDriver().findElement(By.name(name));
    }

    /**
     * Finds an element by its class name.
     *
     * @param className the class name of the element
     * @return the WebElement representing the found element
     */
    private WebElement findElementByClassName(String className) {
        return getWindowsDriver().findElement(By.className(className));
    }

    /**
     * Checks if an element is displayed on the screen.
     *
     * @param element the WebElement to check
     * @return true if the element is displayed, false otherwise
     */
    private boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * Saves a screenshot with the provided screenshot path and returns the absolute path to the saved file.
     *
     * @param screenshotPath the path to save the screenshot
     * @return the absolute path to the saved screenshot file
     */
    private String saveScreenshot(String screenshotPath) {
        File screenshot = getWindowsDriver().getScreenshotAs(OutputType.FILE);
        File newFile = new File(screenshotPath);
        try {
            FileUtils.copyFile(screenshot, newFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newFile.getAbsolutePath();
    }

    /**
     * Appends the provided report text to the report file.
     *
     * @param reportText the text to append to the report file
     */
    private void appendReport(String reportText) {
        File reportFile = new File("target\\report.txt");
        try {
            FileUtils.writeLines(reportFile, Collections.singleton(reportText), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
