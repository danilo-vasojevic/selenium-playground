package org.democrance.testtask.pageObject.components;
import org.democrance.testtask.pageObject.components.base.Tab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TermsConditionsTab extends Tab {
    @FindBy(xpath = "(//span[contains(text(), \"I acknowledge reading and accepting the\")])[1]")
    public WebElement acceptTerms;

    @FindBy(xpath = "(//span[contains(text(), \"I acknowledge reading and accepting the\")])[2]")
    public WebElement acceptOtherTerms; // Bug?

    public TermsConditionsTab(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
