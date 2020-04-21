package hw6.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IframeComponent extends AbstractComponent {
    @FindBy(id = "frame")
    private WebElement iframe;

    @FindBy(id = "frame-button")
    private WebElement iframeButton;


    public IframeComponent(WebDriver driver) {
        super(driver);
    }

    public boolean iframeIsDisplayed() {
        return iframe.isDisplayed();
    }

    public boolean iframeButtonIsDisplayed() {
        return iframeButton.isDisplayed();
    }

    public void focus() {
        getDriver().switchTo().frame(iframe);
    }
}
