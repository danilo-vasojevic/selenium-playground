package org.framework;

import org.junit.jupiter.api.Test;

import static org.framework.utils.Any.*;

public class CreateAccountTest extends Fixture {
    public static final String REGULAR_USER_EMAIL = "9kgr9bkljuro@y1g7mx.com";

    @Test
    public void createAccountWithNewCredentials() {
        String name = String.format("%s %s", randomText(5), randomText(8));
        String email = randomEmail();
        String pass = randomText(15);

        po.home.navigate();
        po.home.navigationBar.profileIcon.click();
        po.login.verifyUrl();
        po.login.verifyPageElements();
        po.login.createAccountLink.click();
        po.createAccount.verifyUrl();
        po.createAccount.verifyPageElements();

        po.wait.forTimeout(1000);
        po.createAccount.nameInput.sendKeys(name);
        po.createAccount.emailInput.sendKeys(email);
        po.createAccount.passwordInput.sendKeys(pass);
        po.wait.forTimeout(1000);
        po.createAccount.submitButton.click();

        po.home.verifyUrl();
        po.home.wait.forCookie("sid");

    }

    @Test
    public void cantCreateAccountIfAlreadyExists() {
        po.createAccount.navigate();
        po.createAccount.nameInput.sendKeys(randomText(10));
        po.createAccount.emailInput.sendKeys(REGULAR_USER_EMAIL);
        po.createAccount.passwordInput.sendKeys(randomText(12));
        po.wait.forTimeout(1000);
        po.createAccount.submitButton.click();
        po.createAccount.wait.untilDisplayed(po.createAccount.getCriticalText("Email is already used"));
        po.createAccount.verifyUrl();
    }

    @Test
    public void noEmptyFieldsAllowedOnCreateAccount() {
        po.createAccount.navigate();
        po.createAccount.submitButton.click();

        po.wait.untilHasText(po.createAccount.errors.get(0), "This field can not be empty");
        po.wait.untilHasText(po.createAccount.errors.get(1), "This field can not be empty");
        po.wait.untilHasText(po.createAccount.errors.get(2), "This field can not be empty");
    }
}
