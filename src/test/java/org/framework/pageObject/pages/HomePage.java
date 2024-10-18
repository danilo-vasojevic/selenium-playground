package org.framework.pageObject.pages;

import org.framework.pageObject.components.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    public final NavigationBar navigationBar;

    public WebElement getButtonByText(String text) {
        List<WebElement> buttons = driver.findElements(By.cssSelector(".button"));
        return buttons.stream()
                .filter(element -> element.getText().contains(text))
                .findFirst().get();
    }

    public HomePage(WebDriver driver) {
        super(driver, "/");

        navigationBar = new NavigationBar(driver);
    }

    public void verifyPageElements(String[] categoryButtons) {
        String[] categories = {"Men", "Women", "Kids"};
        navigationBar.verifyNavItems(categories);
        for (String button: categoryButtons) {
            wait.untilDisplayed(getButtonByText(button));
        }
    }
}
