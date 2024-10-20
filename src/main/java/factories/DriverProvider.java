package factories;

import org.openqa.selenium.WebDriver;

public class DriverProvider {
    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        if(driver == null) {
            driver = BrowserFactory.createBrowser();
        }
        return driver;
    }

    public static WebDriver getDriverIfAny() {
        return driver;
    }

    public static void disposeOfDriver() {
        if(driver == null) return;
        driver.quit();
        driver = null;
    }
}
