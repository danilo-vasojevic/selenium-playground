package org.framework;

import org.framework.pageObject.PageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class Fixture {
    PageObject po;

    @BeforeEach
    public void setUp() {
        po = new PageObject();
        po.start();
    }

    @AfterEach
    public void tearDown() {
        po.quit();
    }
}
