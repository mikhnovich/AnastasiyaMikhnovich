package hw6.pages;

import hw6.components.LogSidebarComponent;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    private final LogSidebarComponent logSidebarComponent;

    @FindBy(css = ".colors select")
    private WebElement colorsSelector;
    @FindBy(xpath = "//*[@type='checkbox']")
    private List<WebElement> checkboxes;
    @FindBy(xpath = "//*[@class='label-checkbox']")
    private List<WebElement> checkboxLabels;
    @FindBy(xpath = "//*[@class='label-radio']")
    private List<WebElement> radioLabels;
    @FindBy(xpath = "//*[@type='radio']")
    private List<WebElement> radios;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        this.logSidebarComponent = new LogSidebarComponent(driver);
    }

    public DifferentElementsPage checkCheckboxBy(String name) {
        clickElementByNameDeterminedInLabel(checkboxes, checkboxLabels, name);
        return this;
    }

    public DifferentElementsPage checkRadiobuttonBy(String name) {
        clickElementByNameDeterminedInLabel(radios, radioLabels, name);
        return this;
    }

    private void clickElementByNameDeterminedInLabel(List<WebElement> elements, List<WebElement> labels, String name) {
        if (elements.size() != labels.size())
            throw new IllegalStateException("Checkboxes does not match labels");

        for (int i = 0; i < labels.size(); i++) {
            if (labels.get(i).getText().equals(name)) {
                elements.get(i).click();
                return;
            }
        }
        throw new NoSuchElementException("No such checkbox with name " + name + " on the Different Elements page");
    }

    public DifferentElementsPage selectColor(String color) {
        new Select(colorsSelector).selectByVisibleText(color);
        return this;
    }

    public LogSidebarComponent getLogSidebarComponent() {
        return logSidebarComponent;
    }
}
