package org.democrance.testtask.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Waiter {
    public static final String DEFAULT_DOWNLOAD_DIR = "C:\\Users\\danil\\Downloads";
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Wait<WebDriver> fluentWait;

    public Waiter(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(ElementNotInteractableException.class, StaleElementReferenceException.class);
    }

    public void untilDisplayed(WebElement element) {
        wait.until(d -> element.isDisplayed());
    }

    public void untilNotDisplayed(WebElement element) {
        fluentWait.until(d -> !element.isDisplayed());
    }

    public void untilHasText(WebElement element, String expText) {
        wait.until(d -> element.getText().contains(expText));
    }

    public void untilEnabled(WebElement element) {
        wait.until(d -> element.isEnabled());
    }

    public void untilHasClass(WebElement element, String clazz) {
        wait.until(d -> element.getAttribute("class").contains(clazz));
    }

    public void forLoadingToAppearAndDisappear() {
        WebElement loading = driver.findElement(By.cssSelector(".loading-background"));
        try {
            this.untilDisplayed(loading);
            this.untilNotDisplayed(loading);
        } catch (TimeoutException e) { /* Ignored */ }
    }

    private boolean checkForFileWithName(String filename) {
        File dir = new File(DEFAULT_DOWNLOAD_DIR);
        File[] dirContents = dir.listFiles();
        assert dirContents != null;
        for (File dirContent : dirContents) {
            if (dirContent.getName().contains(filename)) {
                dirContent.delete();
                return true;
            }
        }
        return false;
    }

    public void untilFileIsDownloaded(String filename) {
        fluentWait.until(d -> checkForFileWithName(filename));
    }

    public void forTimeout(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
