package org.democrance.testtask.pageObject;

import org.democrance.testtask.pageObject.pages.ConfirmationPage;
import org.democrance.testtask.pageObject.pages.QuoteEntryPage;
import org.democrance.testtask.pageObject.pages.SummaryPage;
import org.democrance.testtask.utils.BrowserFactory;
import org.openqa.selenium.WebDriver;

import static org.democrance.testtask.utils.BrowserFactory.data;

public class PageObject {
    private final WebDriver driver;

    public QuoteEntryPage quoteEntryPage;
    public SummaryPage summaryPage;
    public ConfirmationPage confirmationPage;
    public PageObject() {
        this.driver = BrowserFactory.createBrowser();
        quoteEntryPage = new QuoteEntryPage(driver);
        summaryPage = new SummaryPage(driver);
        confirmationPage = new ConfirmationPage(driver);
        driver.get(data.baseUrl());
    }

    public void quit() {
        driver.quit();
    }
}
