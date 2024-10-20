package extensions;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static factories.DriverProvider.getDriverIfAny;

public class ScreenshotOnFailure implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        byte[] screenshot = ((TakesScreenshot) getDriverIfAny()).getScreenshotAs(OutputType.BYTES);
        addScreenshotAsAttachment(screenshot);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] addScreenshotAsAttachment(byte[] screenshot) {
        return screenshot;
    }
}
