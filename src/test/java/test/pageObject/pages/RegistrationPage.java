package test.pageObject.pages;

import io.qameta.allure.Step;
import test.pageObject.components.BaseComponent;
import test.pageObject.components.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegistrationPage extends BaseComponent {
    // Locators
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

    // Components
    public final NavigationBar navigationBar = new NavigationBar();

    public WebElement getCriticalText(String text) {
        List<WebElement> buttons = driver.findElements(By.cssSelector(".text-critical"));
        return buttons.stream()
                .filter(element -> element.getText().contains(text))
                .findFirst().get();
    }

    // Actions
    @Step("Verify elements on registration page")
    public void verifyPageElements() {
        wait.untilDisplayed(nameInput);
        wait.untilDisplayed(emailInput);
        wait.untilDisplayed(passwordInput);
        wait.untilDisplayed(submitButton);

        String[] categories = {"Men", "Women", "Kids"};
        navigationBar.verifyNavItems(categories);
    }
}
