package org.framework.pageObject.pages;

import org.framework.pageObject.components.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {
    public final NavigationBar navigationBar;

    @FindBy(name = "full_name")
    public WebElement nameInput;

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    public WebElement submitButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver, "/account/register");

        navigationBar = new NavigationBar(driver);
    }

    public void verifyPageElements() {
        wait.untilDisplayed(nameInput);
        wait.untilDisplayed(emailInput);
        wait.untilDisplayed(passwordInput);
        wait.untilDisplayed(submitButton);

        String[] categories = {"Men", "Women", "Kids"};
        navigationBar.verifyNavItems(categories);
    }
}
