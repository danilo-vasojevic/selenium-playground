package test.pageObject.components;
import factories.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static factories.DriverProvider.getDriver;

public abstract class BaseComponent {
    protected final WebDriver driver;
    public final Waiter wait;

    protected BaseComponent() {
        this.driver = getDriver();
        this.wait = new Waiter(driver);
        PageFactory.initElements(driver, this);
    }
}
