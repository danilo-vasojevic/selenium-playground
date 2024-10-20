package factories;

import config.DataProvider;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    private final WebDriverWait wait;
    private final Wait<WebDriver> fluentWait;

    public Waiter(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DataProvider.get().waitTimeout()));
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(ElementNotInteractableException.class, StaleElementReferenceException.class);
    }

    public void untilUrlContains(String expUrl) {
        try {
            wait.until(d -> {
                String url = d.getCurrentUrl();
                assert url != null;
                return url.contains(expUrl);
            });
        } catch (TimeoutException e) {
            throw new AssertionError("Timed out waiting for URL: " + expUrl);

        }
    }

    public void untilDisplayed(WebElement element) {
        wait.until(d -> element.isDisplayed());
    }

    public void untilNotDisplayed(WebElement element) {
        fluentWait.until(d -> !element.isDisplayed());
    }

    public void untilHasText(WebElement element, String expText) {
        wait.until(d -> element.getText().contains(expText));
    }

    public void untilEnabled(WebElement element) {
        wait.until(d -> element.isEnabled());
    }

    public void untilHasClass(WebElement element, String clazz) {
        wait.until(d -> element.getAttribute("class").contains(clazz));
    }

    public void forCookie(String cookieName) {
        wait.until(d -> {
            Cookie cookie = d.manage().getCookieNamed(cookieName);
            return cookie != null;
        });
    }

    public void forTimeout(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
