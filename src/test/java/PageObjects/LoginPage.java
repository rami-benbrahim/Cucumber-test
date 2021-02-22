package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"username\"]")
    @CacheLookup
    private WebElement usernamefield;

    @FindBy(xpath = "//*[@id=\"password\"]")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(xpath = "//*[text()=\"Me connecter\"]")
    @CacheLookup
    private WebElement meconnecter;

    @FindBy(xpath = "//*[text()=\"Connectez-vous\"]")
    @CacheLookup
    private WebElement titlepage;

    public void fillUsernameData(String username) {

        WaitUntilElementVisible(usernamefield);
        usernamefield.isEnabled();
        usernamefield.clear();
        usernamefield.sendKeys(username);
    }

    public void fillPasswordData(String password) {

        WaitUntilElementVisible(passwordField);
        passwordField.isEnabled();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {

        WaitUntilElementVisible(meconnecter);
        meconnecter.isEnabled();
        meconnecter.click();
    }

    public boolean errorMessageIsDisplayed() {

       // WaitUntilElementVisible(errorMessageLabel);
        //errorMessageLabel.isDisplayed();
        return true;
    }

    public boolean loginPageIsDisplayed() {

        WaitUntilElementVisible(usernamefield);
        usernamefield.isDisplayed();
        WaitUntilElementVisible(passwordField);
        passwordField.isDisplayed();
        WaitUntilElementVisible(titlepage);
        titlepage.isDisplayed();
        WaitUntilElementVisible(meconnecter);
        meconnecter.isDisplayed();
        return true;
    }
}