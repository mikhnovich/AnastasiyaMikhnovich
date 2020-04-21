package hw6.steps;

import hw6.pages.DifferentElementsPage;
import hw6.pages.MainPage;
import hw6.pages.UsersTablePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class WhenSteps extends BaseStep {

    //Service menu
    @When("I click on {string} tab on the Header menu")
    public void iClickOnTabOnTheHeaderMenu(String name) {
        new MainPage(getDriver())
                .getHeader()
                .clickServiceButton();
    }

    @When("I click the link {string} in Service dropdown")
    public void iClickTheLinkInServiceDropdown(String itemName) {
        new MainPage(getDriver())
                .getHeader()
                .clickDropdownMenuItem(itemName);
    }

    @And("I click on {string} button in Service dropdown")
    public void iClickOnUserTableButtonInServiceDropdown(String itemName) {
        iClickTheLinkInServiceDropdown(itemName);
    }

    @And("I click on {string} button in Header")
    public void iClickOnButtonInHeader(String name) {
        iClickOnTabOnTheHeaderMenu(name);
    }


    @When("I click checkbox Water on the Elements page")
    public void iClickCheckboxWaterOnTheElementsPage() {
        new DifferentElementsPage(getDriver())
                .checkWater();
    }

    @When("I click checkbox Wind on the Elements page")
    public void iClickCheckboxWindOnTheElementsPage() {
        new DifferentElementsPage(getDriver())
                .checkWind();

    }

    @When("I select radiobutton Selen on the Elements page")
    public void iSelectRadiobuttonSelenOnTheElementsPage() {
        new DifferentElementsPage(getDriver())
                .checkSelen();
    }

    @When("I select {string} in colors dropdown")
    public void iSelectColorInColorsDropdown(String color) {
        new DifferentElementsPage(getDriver())
                .selectColor(color);
    }

    @When("I select {string} checkbox for {string}")
    public void iSelectVipCheckboxFor(String checkbox, String name) {
        new UsersTablePage(getDriver())
                .checkVipFor(name);
    }
}
