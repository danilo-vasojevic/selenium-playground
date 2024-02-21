package org.democrance.testtask.pageObject.components;
import org.democrance.testtask.pageObject.components.base.Tab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InformationTab extends Tab {
    @FindBy(xpath = "//input[@data-e2e='field-insured_age']")
    public WebElement dateOfBirth;

    @FindBy(css = "a.is-selectable[role]")
    public List<WebElement> selectableDates;

    @FindBy(css = ".button.is-small")
    List<WebElement> touchSelectButtons;

    @FindBy(xpath = "//button[contains(text(), \"Next\")]")
    public WebElement nextButton;

    public InformationTab(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getTouchSelectButton(String text) {
        return touchSelectButtons.stream()
                .filter(e -> e.getText().contains(text))
                .findFirst()
                .get();
    }
}
