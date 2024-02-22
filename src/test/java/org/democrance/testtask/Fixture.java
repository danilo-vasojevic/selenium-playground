package org.democrance.testtask;

import org.democrance.testtask.pageObject.PageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class Fixture {
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
