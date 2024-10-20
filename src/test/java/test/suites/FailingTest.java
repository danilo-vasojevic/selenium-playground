package test.suites;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.TestSuite;

import static test.Constants.Links.*;

@Feature("Some tests can fail")
public class FailingTest extends TestSuite {

    @Test
    @DisplayName("Fail always and grab screenshot")
    public void fail() {
        po.navigate(REGISTER);
        po.register.verifyPageElements();
        throw new RuntimeException("Test is not implemented yet.");
    }
}
