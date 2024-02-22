package org.democrance.testtask.utils;

import config.DataProvider;
import config.TestDataAndProperties;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.HashMap;

public class BrowserFactory {
    public static TestDataAndProperties data = DataProvider.get();
    public static WebDriver createBrowser() {
        String browserType = data.browser();
        if (browserType != null) {
            return switch (browserType.toLowerCase()) {
                case "chrome" -> createChromeDriver();
                case "firefox" -> createFirefoxDriver();
                default -> {
                    System.err.println("Invalid browser type specified. Defaulting to Chrome.");
                    yield createChromeDriver();
                }
            };
        } else {
            return createChromeDriver();
        }
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        if(data.runHeadless()) options.addArguments("--headless");
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", data.workingDir());
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--test-type");
        WebDriver driver = new ChromeDriver(options);
        setupWebDriver(driver);
        return driver;
    }

    private static WebDriver createFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        HashMap<String, Object> ffPrefs = new HashMap<>();
        options.addPreference("browser.download.folderList", 2);
        options.addPreference("browser.download.manager.showWhenStarting", false);
        options.addPreference("browser.download.dir", data.workingDir());
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");

        WebDriver driver = new FirefoxDriver(options);
        setupWebDriver(driver);
        return driver;
    }

    private static void setupWebDriver(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(data.implicitlyWait()));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(data.pageLoadTimeout()));
        driver.manage().window().setSize(new Dimension(data.windowWidth(), data.windowHeight()));
    }
}
