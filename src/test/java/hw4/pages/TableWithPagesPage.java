package hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TableWithPagesPage extends AbstractPage {

    @FindBy(name = "table-with-pages_length")
    private WebElement showEntriesDropdown;

    @FindBy(css = "tbody > tr")
    private List<WebElement> table;

    @FindBy(css = "#table-with-pages_filter input")
    private WebElement searchInput;

    public TableWithPagesPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getDropdownValues() {
        return Arrays.asList(showEntriesDropdown.getText().split("\n"));
    }

    public void selectDropdownValue(String toSelect) {
        new Select(showEntriesDropdown).selectByVisibleText(toSelect);
    }

    public int getTableRowsCount() {
        return table.size();
    }

    public void searchInTable(String search) {
        searchInput.sendKeys(search);
    }

    public List<String> getTableRowsText() {
        return table.stream()
                .map(row -> row.getText())
                .collect(Collectors.toList());
    }

}
