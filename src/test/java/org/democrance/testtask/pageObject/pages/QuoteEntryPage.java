package org.democrance.testtask.pageObject.pages;
import org.democrance.dto.PolicyDataDTO;
import org.democrance.testtask.pageObject.components.InformationTab;
import org.democrance.testtask.pageObject.components.IssuanceAndPaymentTab;
import org.democrance.testtask.pageObject.components.TermsConditionsTab;
import org.democrance.testtask.pageObject.components.base.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class QuoteEntryPage extends BaseComponent {
    public final InformationTab infoTab;
    public final TermsConditionsTab termsTab;
    public final IssuanceAndPaymentTab detailsTab;

    public QuoteEntryPage(WebDriver driver) {
        super(driver);
        infoTab = new InformationTab(driver);
        termsTab = new TermsConditionsTab(driver);
        detailsTab = new IssuanceAndPaymentTab(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterBasicInformation(PolicyDataDTO data) {
        wait.forLoadingToAppearAndDisappear();
        infoTab.verifyTabTitle("Information");
        infoTab.dateOfBirth.click();
        infoTab.selectableDates.stream().findFirst().get().click();
        infoTab.getTouchSelectButton(data.amount).click();
        infoTab.getTouchSelectButton(data.frequency).click();
        infoTab.nextButton.click();
    }

    public void acceptTermsAndConditions() {
        wait.forLoadingToAppearAndDisappear();
        termsTab.verifyTabTitle("Terms & Conditions");
        wait.untilDisplayed(termsTab.backButton);
        wait.untilHasClass(termsTab.nextButton, "unavailable");
        termsTab.acceptTerms.click();
        wait.untilHasClass(termsTab.nextButton, "unavailable");
        termsTab.acceptOtherTerms.click();
        wait.untilEnabled(termsTab.nextButton);
        termsTab.nextButton.click();
    }

    public void enterPolicyIssuanceAndPaymentData(PolicyDataDTO data) {
        wait.forLoadingToAppearAndDisappear();
        detailsTab.verifyTabTitle("Policy Issuance And Payment");
        detailsTab.selectTitle(data.title);
        detailsTab.fullName.sendKeys(data.name);
        detailsTab.nationality.click();
        detailsTab.nationality.sendKeys(data.nationality.substring(0, 4));
        detailsTab.selectNationality(data.nationality);
        detailsTab.emailAddress.sendKeys(data.email);
        detailsTab.telephone.sendKeys(data.phone);
        detailsTab.idNumber.click(); // Not regular input
        new Actions(driver).sendKeys(data.id).perform();
        detailsTab.expiryDate.click();
        detailsTab.selectableDates.stream().findFirst().get().click();
        detailsTab.nextButton.click();
    }
}
