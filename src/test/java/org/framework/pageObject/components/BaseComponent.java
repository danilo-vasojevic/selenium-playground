package org.framework.pageObject.components;
import org.framework.utils.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseComponent {
    public final WebDriver driver;
    public final Waiter wait;

    protected BaseComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waiter(driver);
        PageFactory.initElements(driver, this);
    }
}
