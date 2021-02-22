package PageObjects;

import Utilities.BaseClass;
import Utilities.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Accèsactespage extends BaseClass {



    public Accèsactespage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void clickacte(String acte) throws Exception {
        WebElement actetoclick = driver.findElement(By.xpath(PropertiesReader.getValue(acte)));
        WaitUntilElementVisible(actetoclick);
        actetoclick.click();
      }



}
