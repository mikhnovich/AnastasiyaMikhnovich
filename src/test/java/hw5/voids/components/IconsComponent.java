package hw5.voids.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class IconsComponent extends AbstractComponent {
    @FindBy(className = "benefit-icon")
    private List<WebElement> icons;

    @FindBy(className = "benefit-txt")
    private List<WebElement> iconTextsElements;

    public IconsComponent(WebDriver driver) {
        super(driver);
    }

    public boolean allIconsAreDisplayed() {
        return icons.stream()
                .allMatch(icon -> icon.isDisplayed());
    }

    public List<String> getMenuItemsText() {
        return iconTextsElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


}
