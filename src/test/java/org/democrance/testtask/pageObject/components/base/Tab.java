package org.democrance.testtask.pageObject.components.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Tab  extends BaseComponent {
    @FindBy(xpath = "//button[@data-e2e='buttonsBar-next']")
    public WebElement nextButton;

    @FindBy(xpath = "//button[@data-e2e='buttonsBar-back']")
    public WebElement backButton;

    @FindBy(xpath = "//div[@class='groupHeader']")
    public WebElement tabHeader;

    protected Tab(WebDriver driver) {
        super(driver);
    }

    public void verifyTabTitle(String expectedTitle) {
        wait.untilDisplayed(tabHeader);
        wait.untilHasText(tabHeader, expectedTitle);
    }
}
