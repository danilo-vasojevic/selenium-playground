package org.framework.pageObject.pages;

import org.framework.pageObject.components.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {
    public final NavigationBar navigationBar;

    @FindBy(name = "full_name")
    private WebElement nameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

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
