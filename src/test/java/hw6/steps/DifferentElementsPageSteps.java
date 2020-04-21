package hw6.steps;

import hw6.components.LogSidebarComponent;
import hw6.pages.DifferentElementsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertTrue;

public class DifferentElementsPageSteps {

    private final DifferentElementsPage differentElementsPage;

    public DifferentElementsPageSteps(WebDriver driver) {
        this.differentElementsPage = new DifferentElementsPage(driver);
    }

    @Step("Check water checkbox")
    public void checkWaterCheckbox() {
        differentElementsPage.checkWater();
    }

    @Step("Check wind checkbox")
    public void checkWindCheckbox() {
        differentElementsPage.checkWind();
    }

    @Step("Check selen checkbox")
    public void checkSelenCheckbox() {
        differentElementsPage.checkSelen();
    }

    @Step("Select {color} color")
    public void selectColor(String color) {
        differentElementsPage.selectColor(color);
    }

    @Step("Logs should be visible")
    public void checkLogsAreVisible() {
        assertTrue(differentElementsPage.getLogSidebarComponent().isLogVisible());
    }

    @Step("Logs should contain {entry}")
    public void logsShouldContain(String entry) {
        LogSidebarComponent logSidebarComponent = differentElementsPage.getLogSidebarComponent();
        assertTrue(logSidebarComponent.containsLogEntryIgnoreTime(entry));
    }
}
