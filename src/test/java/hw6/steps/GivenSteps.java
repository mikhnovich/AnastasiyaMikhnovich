package hw6.steps;

import hw6.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class GivenSteps extends BaseStep {

    @Given("I am on the Main Page")
    public void iAmOnTheMainPage() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.launch();
    }

    @And("I perform login with {string} and {string}")
    public void iPerformLoginWithUsernameAndPassword(String username, String password) {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.login(username, password);
    }

    @Given("I open JDI GitHub site")
    public void iOpenJDIGitHubSite() {
        iAmOnTheMainPage();
    }

    @And("I login as user {string}")
    public void iLoginAsUser(String name) {
        String userName = getProperty("userName");
        String password = getProperty("password");
        new MainPage(getDriver()).login(userName, password);
    }
}
