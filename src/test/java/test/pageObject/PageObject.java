package test.pageObject;

import config.DataProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import test.pageObject.pages.RegistrationPage;
import test.pageObject.pages.HomePage;
import test.pageObject.pages.LoginPage;
import factories.Waiter;

import static factories.DriverProvider.getDriver;
import static factories.BrowserFactory.data;

public class PageObject {
    public final WebDriver driver = getDriver();
    public final Waiter wait = new Waiter(driver);

    // Pages
    public RegistrationPage register = new RegistrationPage();
    public LoginPage login = new LoginPage();
    public HomePage home = new HomePage();

    @Step("Open base page")
    public PageObject start() {
        driver.get(data.baseUrl());
        return this;
    }

    @Step("Navigate to page: '{partialUrl}'")
    public void navigate(String partialUrl) {
        driver.get(String.format("%s%s", DataProvider.get().baseUrl(), partialUrl));
    }

    @Step("Verify URL contains: '{partialUrl}'")
    public void verifyUrl(String partialUrl) {
        wait.untilUrlContains(partialUrl);
    }
}
