package org.democrance.testtask.pageObject.pages;
import org.democrance.testtask.pageObject.components.base.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends BaseComponent {
    @FindBy(xpath = "//button[//span[text()=\"Download Policy schedule\"]]")
    public WebElement downloadPolicySchedule;

    @FindBy(xpath = "//h1[@class='title block']")
    public WebElement title;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyTitle(String expTitle) {
        wait.untilDisplayed(title);
        wait.untilHasText(title, expTitle);
    }

    public void downloadAndVerifyPolicySchedule(String expFileName) {
        downloadPolicySchedule.click();
        wait.untilFileIsDownloaded(expFileName);
    }
}
