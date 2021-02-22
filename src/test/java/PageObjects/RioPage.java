package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RioPage extends BaseClass {

    public RioPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void CheckRIO(String riocode) throws Exception {
        //driver.get("https://cms.sfr.fr/novelli/rioMobile/consultation?selectedLine=0622922692");
        driver.navigate().refresh();
        driver.switchTo().frame("ifrm");
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[text()=\"Votre connexion est en cours\"]"))));
     //   WebElement rio = driver.findElement(By.xpath("//*[contains(text(),'"+ riocode +"')]"));
        WebElement rio = driver.findElement(By.xpath("//*[text()=\"" + riocode + "\"]"));
        WaitUntilElementVisible(rio);
        rio.isDisplayed();

    }

}
