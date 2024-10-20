package test.suites;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import test.TestSuite;

import static test.Constants.Links.*;

@Feature("Page navigation")
public class NavigationTest extends TestSuite {
    @Test
    @DisplayName("Anonymous user can open home page")
    public void openHomePage() {
        po.navigate(HOME);
        po.verifyUrl(HOME);
        String[] buttons = {"SHOP MEN", "SHOP WOMEN", "SHOP KIDS"};
        po.home.verifyPageElements(buttons);
    }

    @Test
    @DisplayName("Anonymous user can open create account page")
    public void openCreateAccountPage() {
        po.navigate(REGISTER);
        po.verifyUrl(REGISTER);
        po.register.verifyPageElements();
    }

    @Test
    @DisplayName("Anonymous user can open login page")
    public void openLoginPage() {
        po.navigate(LOGIN);
        po.verifyUrl(LOGIN);
        po.login.verifyPageElements();
    }
}
