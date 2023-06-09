package com.test.steps;

import com.test.pageobjects.CCleanerInstaller;
import com.test.pageobjects.CCleanerWebPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * The CCleanerStepsUI class defines the UI steps for the CCleaner installation process.
 * It contains methods to perform various actions such as downloading the app, confirming the installer is opened,
 * checking specific guidelines, and installing and running the app.
 */
public class CCleanerStepsUI {

    @Given("user downloads the desktop app")
    public void downloadApp() {
        new CCleanerWebPage().clickOnCookiesAcceptButton();
        new CCleanerWebPage().clickOnDownloadButton();
        new CCleanerWebPage().downloadCCleanerApp();
    }

    @Given("user confirms the CCleaner installer is opened")
    public void confirmAppIsOpened() {
        new CCleanerInstaller().ccleanerInstallerIsOpened();
    }

    @When("user checks the ACR-065 guideline")
    public void checkGuidelineACR065() {
        new CCleanerInstaller().checkGuidelineACR065();
    }

    @And("user checks the ACR-040 guideline")
    public void checkGuidelineACR040() {
        new CCleanerInstaller().checkGuidelineACR040();
    }

    @And("user checks the ACR-046 guideline")
    public void checkGuidelineACR046() {
        new CCleanerInstaller().checkGuidelineACR046();
    }

    @And("user checks the ACR-055 guideline")
    public void checkGuidelineACR055() {
        new CCleanerInstaller().checkGuidelineACR055();
    }

    @Then("user installs and runs the app")
    public void installAndRunApp() {
        new CCleanerInstaller().installAndRunApp();
    }
}
