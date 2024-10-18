package org.framework;
import org.junit.jupiter.api.*;

public class TestSuite extends Fixture {
    @Test
    public void openHomePage() {
        po.home.navigate();
        po.home.verifyUrl();
        String[] buttons = {"SHOP MEN", "SHOP WOMEN", "SHOP KIDS"};
        po.home.verifyPageElements(buttons);
    }

    @Test
    public void openCreateAccountPage() {
        po.createAccount.navigate();
        po.createAccount.verifyUrl();
        po.createAccount.verifyPageElements();
    }

    @Test
    public void openLoginPage() {
        po.login.navigate();
        po.login.verifyUrl();
        po.login.verifyPageElements();
    }
}
