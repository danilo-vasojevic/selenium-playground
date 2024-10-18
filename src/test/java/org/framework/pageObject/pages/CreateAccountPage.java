package org.framework.pageObject.pages;

import org.framework.pageObject.components.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(css = ".field-error")
    public List<WebElement> errors;

    public WebElement getCriticalText(String text) {
        List<WebElement> buttons = driver.findElements(By.cssSelector(".text-critical"));
        return buttons.stream()
                .filter(element -> element.getText().contains(text))
                .findFirst().get();
    }

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
