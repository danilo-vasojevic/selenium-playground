package org.democrance.testtask;

import org.democrance.dto.PolicyDataDTO;
import org.democrance.testtask.pageObject.PageObject;
import org.democrance.testtask.utils.Any;
import org.democrance.testtask.utils.BrowserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.democrance.testtask.utils.Any.randomNumeric;
import static org.democrance.testtask.utils.BrowserFactory.data;

public class TestFixture {
    PageObject po;

    @BeforeEach
    public void setUp() {
        po = new PageObject();
    }

    @AfterEach
    public void tearDown() {
        po.quit();
    }
}
