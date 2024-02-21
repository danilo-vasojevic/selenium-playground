package org.democrance.testtask.pageObject.components.base;
import org.democrance.testtask.utils.Waiter;
import org.openqa.selenium.WebDriver;

public abstract class BaseComponent {
    protected final WebDriver driver;
    public final Waiter wait;

    protected BaseComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waiter(driver);
    }
}
