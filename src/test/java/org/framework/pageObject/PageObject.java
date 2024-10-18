package org.framework.pageObject;

import org.framework.pageObject.pages.CreateAccountPage;
import org.framework.pageObject.pages.HomePage;
import org.framework.pageObject.pages.LoginPage;
import org.framework.utils.BrowserFactory;
import org.openqa.selenium.WebDriver;

import static org.framework.utils.BrowserFactory.data;

public class PageObject {
    private final WebDriver driver;

    public CreateAccountPage createAccount;
    public LoginPage login;
    public HomePage home;

    public PageObject() {
        this.driver = BrowserFactory.createBrowser();
        createAccount = new CreateAccountPage(driver);
        login = new LoginPage(driver);
        home = new HomePage(driver);
    }

    public void start() {
        driver.get(data.baseUrl());
    }

    public void quit() {
        driver.quit();
    }
}
