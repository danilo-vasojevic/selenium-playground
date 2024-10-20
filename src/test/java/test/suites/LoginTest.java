package test.suites;

import factories.Any;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.TestSuite;

import static test.Constants.Links.*;
import static test.Constants.Waits.*;

@Feature("User login page")
public class LoginTest extends TestSuite {
    public static final String REGULAR_USER_EMAIL = "9kgr9bkljuro@y1g7mx.com";
    public static final String REGULAR_USER_PASS = "6e0nurcz5lvkgwxfmpz2";

    @Test
    @DisplayName("Anonymous user can login with correct credentials")
    public void loginWithProperAccount() {
        po.navigate(HOME);
        po.home.navigationBar.profileIcon.click();
        po.verifyUrl(LOGIN);
        po.login.verifyPageElements();

        po.wait.forTimeout(SHORT_WAIT);
        po.login.emailInput.sendKeys(REGULAR_USER_EMAIL);
        po.login.passwordInput.sendKeys(REGULAR_USER_PASS);
        po.wait.forTimeout(SHORT_WAIT);
        po.login.submitButton.click();

        po.verifyUrl(HOME);
        po.home.navigationBar.profileIcon.click();
        po.home.wait.untilUrlContains(HOME);
        po.wait.forCookie("sid");
    }

    @Test
    @DisplayName("Anonymous user cant login without proper credentials")
    public void cantLoginWithIncorrectCredentials() {
        po.navigate(HOME);
        po.home.navigationBar.profileIcon.click();
        po.verifyUrl(LOGIN);
        po.login.verifyPageElements();

        po.wait.forTimeout(SHORT_WAIT);
        po.login.emailInput.sendKeys(Any.randomEmail());
        po.login.passwordInput.sendKeys(REGULAR_USER_PASS);
        po.wait.forTimeout(SHORT_WAIT);
        po.login.submitButton.click();

        po.login.wait.untilDisplayed(po.login.getCriticalText("Invalid email or password"));
        po.navigate(LOGIN);
        po.wait.forTimeout(LONG_WAIT);
        po.home.wait.untilUrlContains(LOGIN);

        po.wait.forTimeout(SHORT_WAIT);
        po.login.emailInput.sendKeys(REGULAR_USER_EMAIL);
        po.login.passwordInput.sendKeys(Any.randomText(12));
        po.wait.forTimeout(SHORT_WAIT);
        po.login.submitButton.click();

        po.login.wait.untilDisplayed(po.login.getCriticalText("Invalid email or password"));
        po.navigate(LOGIN);
        po.wait.forTimeout(LONG_WAIT);
        po.home.wait.untilUrlContains(LOGIN);
    }
}
