package hw5;

import hw4.MyChromeDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ScreenshotListener extends TestListenerAdapter {

    @Attachment(value = "screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        try {
            return ((TakesScreenshot) MyChromeDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        takeScreenshot();
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        takeScreenshot();
    }
}
