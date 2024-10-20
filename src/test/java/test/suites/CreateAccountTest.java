package test.suites;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.TestSuite;

import static factories.Any.randomEmail;
import static factories.Any.randomText;
import static test.Constants.Links.HOME;
import static test.Constants.Links.REGISTER;
import static test.Constants.Waits.SHORT_WAIT;

@Feature("User create account flow")
public class CreateAccountTest extends TestSuite {
    public static final String REGULAR_USER_EMAIL = "9kgr9bkljuro@y1g7mx.com";

    @Test
    @DisplayName("Anonymous user can create new account with fresh set of credentials")
    public void createAccountWithNewCredentials() {
        String name = String.format("%s %s", randomText(5), randomText(8));
        String email = randomEmail();
        String pass = randomText(15);

        po.navigate(HOME);
        po.home.navigationBar.profileIcon.click();
        po.verifyUrl(HOME);
        po.login.verifyPageElements();
        po.login.createAccountLink.click();
        po.verifyUrl(REGISTER);
        po.register.verifyPageElements();

        po.wait.forTimeout(SHORT_WAIT);
        po.register.nameInput.sendKeys(name);
        po.register.emailInput.sendKeys(email);
        po.register.passwordInput.sendKeys(pass);
        po.wait.forTimeout(SHORT_WAIT);
        po.register.submitButton.click();

        po.verifyUrl(HOME);
        po.wait.forCookie("sid");

    }

    @Test
    @DisplayName("Anonymous user can not create new account with existing set of credentials")
    public void cantCreateAccountIfAlreadyExists() {
        po.navigate(REGISTER);
        po.register.nameInput.sendKeys(randomText(10));
        po.register.emailInput.sendKeys(REGULAR_USER_EMAIL);
        po.register.passwordInput.sendKeys(randomText(12));
        po.wait.forTimeout(SHORT_WAIT);
        po.register.submitButton.click();
        po.register.wait.untilDisplayed(po.register.getCriticalText("Email is already used"));
        po.verifyUrl(REGISTER);
    }

    @Test
    @DisplayName("Anonymous user can not create new account without required fields")
    public void noEmptyFieldsAllowedOnCreateAccount() {
        po.navigate(REGISTER);
        po.register.submitButton.click();

        po.wait.untilHasText(po.register.errors.get(0), "This field can not be empty");
        po.wait.untilHasText(po.register.errors.get(1), "This field can not be empty");
        po.wait.untilHasText(po.register.errors.get(2), "This field can not be empty");
    }
}
