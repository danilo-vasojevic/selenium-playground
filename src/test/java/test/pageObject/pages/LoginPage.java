package test.pageObject.pages;

import io.qameta.allure.Step;
import test.pageObject.components.BaseComponent;
import test.pageObject.components.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BaseComponent {
    // Locators
    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    public WebElement submitButton;

    @FindBy(linkText = "Create an account")
    public WebElement createAccountLink;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPasswordLink;

    public WebElement getCriticalText(String text) {
        List<WebElement> buttons = driver.findElements(By.cssSelector(".text-critical"));
        return buttons.stream()
                .filter(element -> element.getText().contains(text))
                .findFirst().get();
    }

    // Components
    public final NavigationBar navigationBar = new NavigationBar();

    // Actions
    @Step("Verify elements on Login page")
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
