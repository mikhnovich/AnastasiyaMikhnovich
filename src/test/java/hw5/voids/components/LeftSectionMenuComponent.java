package hw5.voids.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class LeftSectionMenuComponent extends AbstractComponent {
    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> leftSideMenuItems;

    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> leftSideMenuItemsText;

    public LeftSectionMenuComponent(WebDriver driver) {
        super(driver);
    }

    public boolean leftSideMenuItemsAreDisplayed() {
        return leftSideMenuItems.stream()
                .allMatch(item -> item.isDisplayed());
    }

    public List<String> getLeftSideMenuItemsText() {
        return leftSideMenuItemsText.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


}
