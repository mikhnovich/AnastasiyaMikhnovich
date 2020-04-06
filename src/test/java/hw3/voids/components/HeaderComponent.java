package hw3.voids.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HeaderComponent extends AbstractComponent {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> menuItems;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public boolean isUserNameVisible() {
        return userName.isDisplayed();
    }

    public String getUserName() {
        return userName.getText();
    }

    public boolean allMenuItemsAreDisplayed() {
        return menuItems.stream()
                .allMatch(item -> item.isDisplayed());
    }

    public List<String> getMenuItemsText() {
        return menuItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
