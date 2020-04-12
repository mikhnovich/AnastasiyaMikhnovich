package hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    public void checkDefaultDropdownValue() {
        showEntriesDropdown.getText().startsWith("5");
    }

    public void selectNewValue() {
        new Select(showEntriesDropdown).selectByVisibleText("10");
    }

    public int getTableRowsCount() {
        int size = table.size();
        return size;
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
