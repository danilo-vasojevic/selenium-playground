package org.democrance.testtask.pageObject.components;

import org.democrance.testtask.pageObject.components.base.Tab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class IssuanceAndPaymentTab extends Tab {
    @FindBy(css = ".button.is-small")
    public List<WebElement> titles;

    @FindBy(xpath = "//input[@name='full_name']")
    public WebElement fullName;

    @FindBy(xpath = "//input[@data-type='select']")
    public WebElement nationality;

    @FindBy(css = "a.dropdown-item")
    public List<WebElement> nationalityOptions;

    @FindBy(xpath = "//input[@data-e2e='field-email_address']")
    public WebElement emailAddress;

    @FindBy(xpath = "//input[@type='tel']")
    public WebElement telephone;

    @FindBy(xpath = "//input[contains(@class, 'masked')]")
    public WebElement idNumber;

    @FindBy(xpath = "//input[@data-e2e='field-emirates_id_expiry_date']")
    public WebElement expiryDate;

    @FindBy(css = "a.is-selectable[role]")
    public List<WebElement> selectableDates;

    public IssuanceAndPaymentTab(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectTitle(String title) {
        titles.stream().filter(t -> Objects.equals(t.getText(), title))
                .findFirst().get().click();
    }

    public void selectNationality(String nationality) {
        nationalityOptions.stream().filter(t -> Objects.equals(t.getText(), nationality))
                .findFirst().get().click();
    }
}
