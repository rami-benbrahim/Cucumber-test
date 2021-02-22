package StepDefinitions;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import Utilities.PropertiesReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;


    public LoginSteps() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());

    }


    @Given("Login form in login page")
    public void loginPage() {
        LoginPage login = new LoginPage(driver, wait);
        login.loginPageIsDisplayed();
    }

    @When("Submit username using \"(.*)\" and password using \"(.*)\"")
    public void submitEmailPassword(String username, String password) {
        LoginPage login = new LoginPage(driver, wait);
        login.fillUsernameData(username);
        login.fillPasswordData(password);
        login.clickSignInButton();
    }

    @Then("Success login")
    public void successLogin() throws Exception {
        HomePage home = new HomePage(driver, wait);
        Assert.assertTrue(home.homePageExtranetAfterLoginIsDisplayed());
    }
}