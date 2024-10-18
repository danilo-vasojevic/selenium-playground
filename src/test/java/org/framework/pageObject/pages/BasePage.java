package org.framework.pageObject.pages;
import config.DataProvider;
import org.framework.pageObject.components.BaseComponent;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends BaseComponent {
    private final String partialUrl;
    private final String url;


    protected BasePage(WebDriver driver, String url) {
        super(driver);
        this.partialUrl = url;
        this.url = String.format("%s%s", DataProvider.get().baseUrl(), partialUrl);
    }

    public void navigate() {
        if (this.partialUrl == null) {
            throw new IllegalArgumentException("Can't navigate. Page URL not set.");
        }
        driver.get(this.url);
    }

    public void verifyUrl() {
        if (this.partialUrl == null) {
            throw new IllegalArgumentException("Can not verify url. Url is not defined.");
        }
        wait.untilUrlEquals(this.url);
    }
}
