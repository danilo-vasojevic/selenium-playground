package org.democrance.testtask.pageObject.pages;
import org.democrance.testtask.pageObject.components.PaymentModal;
import org.democrance.testtask.pageObject.components.base.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage extends BaseComponent {
    public final PaymentModal paymentModal;

    @FindBy(xpath = "//button[@data-e2e='buttonsBar-next']")
    public WebElement confirm;

    @FindBy(xpath = "//h2[@class='subtitle summary-header-content']")
    public WebElement quoteRefNumber;

    public SummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

        paymentModal = new PaymentModal(driver);
    }

    public void confirmAndBuyNow() {
        wait.untilHasText(quoteRefNumber, "Quotation Reference Number");
        wait.untilDisplayed(confirm);
        wait.forTimeout(1000);
        confirm.click();
    }
}
