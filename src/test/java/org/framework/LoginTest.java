package org.framework;

import org.framework.utils.Any;
import org.junit.jupiter.api.Test;

public class LoginTest extends Fixture {
    public static final String REGULAR_USER_EMAIL = "9kgr9bkljuro@y1g7mx.com";
    public static final String REGULAR_USER_PASS= "6e0nurcz5lvkgwxfmpz2";

    @Test
    public void loginWithProperAccount() {
        po.home.navigate();
        po.home.navigationBar.profileIcon.click();
        po.login.verifyUrl();
        po.login.verifyPageElements();

        po.wait(1000);
        po.login.emailInput.sendKeys(REGULAR_USER_EMAIL);
        po.login.passwordInput.sendKeys(REGULAR_USER_PASS);
        po.wait(1000);
        po.login.submitButton.click();

        po.home.verifyUrl();
        po.home.navigationBar.profileIcon.click();
        po.home.wait.untilUrlContains("/account");
    }

    @Test
    public void cantLoginWithIncorrectCredentials() {
        po.home.navigate();
        po.home.navigationBar.profileIcon.click();
        po.login.verifyUrl();
        po.login.verifyPageElements();

        po.wait(1000);
        po.login.emailInput.sendKeys(Any.randomEmail());
        po.login.passwordInput.sendKeys(REGULAR_USER_PASS);
        po.wait(1000);
        po.login.submitButton.click();

        po.login.wait.untilDisplayed(po.login.getCriticalText("Invalid email or password"));
        po.navigateTo("/account");
        po.wait(5000);
        po.home.wait.untilUrlContains("/account/login");

        po.wait(1000);
        po.login.emailInput.sendKeys(REGULAR_USER_EMAIL);
        po.login.passwordInput.sendKeys(Any.randomText(12));
        po.wait(1000);
        po.login.submitButton.click();

        po.login.wait.untilDisplayed(po.login.getCriticalText("Invalid email or password"));
        po.navigateTo("/account");
        po.wait(5000);
        po.home.wait.untilUrlContains("/account/login");
    }
}
