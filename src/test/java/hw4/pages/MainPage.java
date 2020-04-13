package hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class MainPage extends AbstractPage {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void launch() {
        getDriver().get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public boolean isUsernameVisible() {
        return getHeaderComponent().isUserNameVisible();
    }

    public String getUsername() {
        return getHeaderComponent().getUserName();
    }

    public void login(String username, String password) {
        userIcon.click();
        getHeaderComponent().enterFirstName(username);
        getHeaderComponent().enterPassword(password);
        getHeaderComponent().submit();
    }

    public boolean areAllHeaderMenuItemsDisplayed() {
        return getHeaderComponent().allMenuItemsAreDisplayed();
    }

    public List<String> getHeaderMenuItemsNames() {
        return getHeaderComponent().getMenuItemsText();
    }

    public void focusOnPage() {
        getDriver().switchTo().defaultContent();
    }

    public void clickServiceMenuItem() {
        getHeaderComponent().clickServiceMenuItem();
    }

    public void openTableWithPages() {
        getHeaderComponent().openTableWithPages();
    }

    public void goToMetalsAndColoursPage() {
        getHeaderComponent().goToMetalsAndColoursPage();
    }
}
