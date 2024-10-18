package org.framework.pageObject.pages;

import org.framework.pageObject.components.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public final NavigationBar navigationBar;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(linkText = "Create an account")
    private WebElement createAccountLink;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPasswordLink;

    public LoginPage(WebDriver driver) {
        super(driver, "/account/login");

        navigationBar = new NavigationBar(driver);
    }

    public void verifyPageElements() {
        wait.untilDisplayed(emailInput);
        wait.untilDisplayed(passwordInput);
        wait.untilDisplayed(submitButton);
        wait.untilDisplayed(createAccountLink);
        wait.untilDisplayed(forgotPasswordLink);

        String[] categories = {"Men", "Women", "Kids"};
        navigationBar.verifyNavItems(categories);
    }
}
