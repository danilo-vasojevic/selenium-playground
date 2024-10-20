package test;

import factories.DriverProvider;
import extensions.ScreenshotOnFailure;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import test.pageObject.PageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@Epic("Evershop automation")
@ExtendWith(ScreenshotOnFailure.class)
public class TestSuite {
    public static PageObject po;

    @BeforeEach
    public void beforeEach() {
        DriverProvider.disposeOfDriver();
        po = new PageObject().start();
    }

    @AfterEach
    public void afterEach() {
        // TODO: Clean up browser, caches etc.
    }

    @AfterAll
    public static void tearDown() {
        DriverProvider.disposeOfDriver();
    }
}
