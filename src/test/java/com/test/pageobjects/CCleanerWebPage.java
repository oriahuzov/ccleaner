package com.test.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.DownloadOptions.using;
import static com.codeborne.selenide.Selenide.$;
import static com.test.util.Util.setAppData;
import static java.time.Duration.ofSeconds;

/**
 * The CCleanerWebPage class represents the web page of CCleaner and provides methods to interact with the page elements.
 */
public class CCleanerWebPage {

    private final SelenideElement cookiesAcceptButton = $(By.xpath("//button[contains(text(),'OK')]"));
    private final SelenideElement downloadButton = $(By.xpath("//*[@data-qa-id='FreeDownloadBtn']"));
    private final SelenideElement freeDownloadButton = $(By.xpath("//*[@data-qa-id='freeDownloadBtn']"));

    public CCleanerWebPage() {
    }

    /**
     * Clicks on the cookies accept button on the CCleaner web page.
     */
    public void clickOnCookiesAcceptButton() {
        cookiesAcceptButton.shouldBe(Condition.visible).click();
    }

    /**
     * Clicks on the download button on the CCleaner web page.
     * Scrolls into view if necessary before clicking.
     */
    public void clickOnDownloadButton() {
        downloadButton.shouldBe(Condition.visible).scrollIntoView(true).click();
    }

    /**
     * Downloads the CCleaner app by clicking on the free download button on the CCleaner web page.
     * Waits for the download to complete and sets the downloaded file's path in the app data.
     *
     * @throws RuntimeException if the downloaded file is not found
     */
    public void downloadCCleanerApp() {
        try {
            File downloadedFile = freeDownloadButton.download(using(FileDownloadMode.FOLDER)
                    .withTimeout(ofSeconds(60)));
            setAppData("pathToFile", downloadedFile.getAbsolutePath());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
