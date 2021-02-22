package PageObjects;

import Utilities.BaseClass;
import Utilities.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass {

    public HomePage(WebDriver driver, WebDriverWait wait) throws Exception {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    PropertiesReader propertiesReader = new PropertiesReader();


    public boolean homePageExtranetAfterLoginIsDisplayed() throws Exception {
        WebElement numerolignefield = driver.findElement(By.xpath(PropertiesReader.getValue("numerolignefield")));
        WebElement Deconnection = driver.findElement(By.xpath(PropertiesReader.getValue("Deconnection")));
        WebElement loginfixefield = driver.findElement(By.xpath(PropertiesReader.getValue("loginfixefield")));


        WaitUntilElementVisible(Deconnection);
        Deconnection.isDisplayed();
        WaitUntilElementVisible(numerolignefield);
        numerolignefield.isDisplayed();
        WaitUntilElementVisible(loginfixefield);
        loginfixefield.isDisplayed();
        return true;
    }

    public void chercherligne(String ligne) throws Exception {
        WebElement numerolignefield = driver.findElement(By.xpath(PropertiesReader.getValue("numerolignefield")));

        WaitUntilElementVisible(numerolignefield);
        numerolignefield.isEnabled();
        numerolignefield.click();
        numerolignefield.clear();
        numerolignefield.sendKeys(ligne);
        numerolignefield.sendKeys(Keys.ENTER);

        WebElement choisir = driver.findElement(By.xpath(PropertiesReader.getValue("choisir")));
        choisir.click();
    }
}