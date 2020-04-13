package hw4.pages;

import hw4.testdata.TestData;
import hw4.testdata.enums.Colour;
import hw4.testdata.enums.Element;
import hw4.testdata.enums.Metal;
import hw4.testdata.enums.Vegetable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MetalAndColorsPage extends AbstractPage {

    @FindBy(css = "#odds-selector > p label")
    private List<WebElement> summaryLine1;

    @FindBy(css = "#even-selector > p label")
    private List<WebElement> summaryLine2;

    @FindBy(css = "#elements-checklist label")
    private List<WebElement> elementsElements;

    @FindBy(css = "#colors .bootstrap-select")
    private WebElement colorsElement;

    @FindBy(css = "#colors ul > li")
    private List<WebElement> colorsDropdownElements;

    @FindBy(css = ".metals .bootstrap-select")
    private WebElement metals;

    @FindBy(css = ".metals .caret")
    private WebElement metalsElement;

    @FindBy(css = "#metals ul > li")
    private List<WebElement> metalsDropdownElements;

    @FindBy(id = "vegetables")
    private WebElement vegetablesElement;

    @FindBy(xpath = "//*[@id='vegetables']//label[text()='Vegetables']")
    private WebElement vegetablesDefaultElement;

    @FindBy(css = "#vegetables .dropdown-menu li")
    private List<WebElement> vegetablesDropdownElements;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@class = 'panel-body-list results']")
    private WebElement leftResultsBar;

    public MetalAndColorsPage(WebDriver driver) {
        super(driver);
    }

    public void setColor(String color) {
        if (!color.equals(Colour.COLORS.toString())) {
            setWebElement(colorsElement, colorsDropdownElements, colorsElement, color);
        }
    }

    public void setMetal(String metal) {
        if (!metal.equals(Metal.METALS.toString())) {
            setWebElement(metalsElement, metalsDropdownElements, metals, metal);
        }
    }

    public void setVegetable(List<Vegetable> vegetable) {
        if (!vegetable.get(0).toString().equals(Vegetable.VEGETABLES.toString())) {
            vegetablesElement.click();
            uncheckDefaultVegetablesElement();
            for (Vegetable vegetableToSet : vegetable) {
                setElements(vegetablesDropdownElements, vegetableToSet.toString());
            }
        }
    }

    private void uncheckDefaultVegetablesElement() {
        vegetablesDefaultElement.click();
    }

    public void setElement(List<Element> element) {
        if (element != null) {
            for (Element elemToSet : element) {
                setElements(elementsElements, elemToSet.toString());
            }
        }
    }

    public void setSummaryLine1(String value) {
        setNumber(value, summaryLine1);
    }

    public void setSummaryLine2(String value) {
        setNumber(value, summaryLine2);
    }

    private void setNumber(String value, List<WebElement> whereToSet) {
        setElements(whereToSet, value);
    }

    private void setWebElement(WebElement elemToSet, List<WebElement> whatWaitToAppear, WebElement elemTocCheck, String valueToSet) {
        elemToSet.click();
        setElements(whatWaitToAppear, valueToSet);
    }

    private void setElements(List<WebElement> elementsToSet, String value) {
        for (WebElement element : elementsToSet) {
            if (element.getText().equals(value)) {
                element.click();
            }
        }
    }

    public void fillForm(TestData testData) {
        setSummaryLine1(testData.getSummaryLine1());
        setSummaryLine2(testData.getSummaryLine2());
        setColor(testData.getColors().toString());
        setElement(testData.getElements());
        setMetal(testData.getMetals().toString());
        setVegetable(testData.getVegetables());
    }

    public void submitForm() {
        submitButton.click();
    }

    public Map<String, String> getLeftBarResults() {
        return Arrays.stream(leftResultsBar.getText().split("\n"))
                .collect(Collectors.toMap(s -> s.substring(0, s.indexOf(":")).trim(), s -> s.substring(s.indexOf(":") + 1).trim()));
    }
}
