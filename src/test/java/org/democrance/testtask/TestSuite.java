package org.democrance.testtask;
import org.democrance.testtask.dto.PolicyDataDTO;
import org.democrance.testtask.utils.Any;
import org.junit.jupiter.api.*;

import static org.democrance.testtask.utils.Any.*;

public class TestSuite extends TestFixture {
    @Test
    public void getQuote() {
        PolicyDataDTO validData = Any.validPolicyData();

        po.quoteEntryPage.enterBasicInformation(validData);
        po.quoteEntryPage.acceptTermsAndConditions();
        po.quoteEntryPage.enterPolicyIssuanceAndPaymentData(validData);
        po.summaryPage.confirmAndBuyNow();
        po.summaryPage.paymentModal.generateInvoice(randomNumeric(5));
        po.confirmationPage.verifyTitle("Congratulations!");
        po.confirmationPage.downloadAndVerifyPolicySchedule("COI-UAE");
    }
}
