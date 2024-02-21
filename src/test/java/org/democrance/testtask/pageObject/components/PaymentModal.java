package org.democrance.testtask.pageObject.components;
import org.democrance.testtask.pageObject.components.base.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentModal extends BaseComponent {
    @FindBy(xpath = "//button[@data-provider='democrance']")
    public WebElement generateInvoice;

    @FindBy(xpath = "//input[contains(@data-e2e, 'field-payment_reference')]")
    public WebElement reference;

    @FindBy(xpath = "//button[contains(@class, 'payment-button')]")
    public WebElement continueBtn;
    
    public PaymentModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public void generateInvoice(String paymentRef) {
        wait.untilDisplayed(generateInvoice);
        generateInvoice.click();
        reference.sendKeys(paymentRef);
        wait.forTimeout(1000);
        continueBtn.click();
    }
}
