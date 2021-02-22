package StepDefinitions.Novelli;

import PageObjects.Accèsactespage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RioPage;
import StepDefinitions.Hooks;
import Utilities.PropertiesReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConsultationRio {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;


    public ConsultationRio() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());

    }

    @Given("se connecter avec \"(.*)\" / \"(.*)\"")
    public void login(String username, String password) throws Exception {
        LoginPage login = new LoginPage(driver, wait);
        login.loginPageIsDisplayed();
        login.fillUsernameData(username);
        login.fillPasswordData(password);
        login.clickSignInButton();
        HomePage home = new HomePage(driver, wait);
        Assert.assertTrue(home.homePageExtranetAfterLoginIsDisplayed());
    }

    @When("je cherche la ligne \"(.*)\" et j'ouvre le RIO acte")
    public void chercherligne(String ligne) throws Exception {
        HomePage home = new HomePage(driver, wait);
        Accèsactespage acte = new Accèsactespage(driver, wait);
        home.chercherligne(ligne);
        acte.clickacte("Rio");
    }

    @Then("verifier rio visible \"(.*)\"")
    public void successLogin(String riocode) throws Exception {
        RioPage rioPage = new RioPage(driver, wait);
        rioPage.CheckRIO(riocode);
    }
}