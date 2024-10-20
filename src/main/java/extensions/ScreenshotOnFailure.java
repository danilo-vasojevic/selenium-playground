package extensions;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static factories.DriverProvider.getDriver;

public class ScreenshotOnFailure implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        WebDriver driver = getDriver();
        if(driver == null) throw new IllegalArgumentException("Driver is null when taking screenshot");
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        byte[] ignored = addScreenshotAsAttachment(screenshot);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] addScreenshotAsAttachment(byte[] screenshot) {
        return screenshot;
    }
}
