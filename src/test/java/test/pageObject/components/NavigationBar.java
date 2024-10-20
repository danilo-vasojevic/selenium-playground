package test.pageObject.components;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends BaseComponent {
    @FindBy(css = "a.logo-icon")
    public WebElement homeLink;

    @FindBy(css = "a.search-icon")
    public WebElement searchIcon;

    @FindBy(css = "a.mini-cart-icon")
    public WebElement cartIcon;

    @FindBy(xpath = "(//div[contains(@class, 'self-center')])[3]")
    public WebElement profileIcon;

    public WebElement getCategoryElement(String category) {
        return driver.findElement(By.xpath("//li[@class='nav-item']//a[text()='" + category + "']"));
    }

    public void verifyNavItems(String... categories) {
        wait.untilDisplayed(homeLink);
        wait.untilDisplayed(searchIcon);
        wait.untilDisplayed(cartIcon);
        wait.untilDisplayed(profileIcon);

        for (String cat: categories) {
            wait.untilDisplayed(getCategoryElement(cat));
        }
    }
}
