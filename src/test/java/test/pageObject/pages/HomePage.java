package test.pageObject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.pageObject.components.BaseComponent;
import test.pageObject.components.NavigationBar;

import java.util.List;

public class HomePage extends BaseComponent {
    // Locators
    public WebElement getButtonByText(String text) {
        List<WebElement> buttons = driver.findElements(By.cssSelector(".button"));
        return buttons.stream()
                .filter(element -> element.getText().contains(text))
                .findFirst().get();
    }

    // Components
    public final NavigationBar navigationBar = new NavigationBar();

    // Actions
    @Step("Verify home page elements")
    public void verifyPageElements(String[] categoryButtons) {
        String[] categories = {"Men", "Women", "Kids"};
        navigationBar.verifyNavItems(categories);
        for (String button : categoryButtons) {
            wait.untilDisplayed(getButtonByText(button));
        }
    }
}
