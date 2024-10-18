package org.framework.pageObject;

import config.DataProvider;
import org.framework.pageObject.pages.CreateAccountPage;
import org.framework.pageObject.pages.HomePage;
import org.framework.pageObject.pages.LoginPage;
import org.framework.utils.BrowserFactory;
import org.framework.utils.Waiter;
import org.openqa.selenium.WebDriver;

import static org.framework.utils.BrowserFactory.data;

public class PageObject {
    private final WebDriver driver;

    public final Waiter wait;

    public CreateAccountPage createAccount;
    public LoginPage login;
    public HomePage home;

    public PageObject() {
        this.driver = BrowserFactory.createBrowser();
        wait = new Waiter(driver);

        createAccount = new CreateAccountPage(driver);
        login = new LoginPage(driver);
        home = new HomePage(driver);
    }

    public void start() {
        driver.get(data.baseUrl());
    }

    public void navigateTo(String partialUrl) {
        driver.get(String.format("%s%s", DataProvider.get().baseUrl(), partialUrl));
    }

    public void quit() {
        driver.quit();
    }
}
