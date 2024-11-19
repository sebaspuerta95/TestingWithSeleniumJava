package formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThankPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By successAlert = By.cssSelector("[class*='alert']");

    public ThankPage (WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver,5);
    }

    public String getSuccessAlert(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert));
        return driver.findElement(successAlert).getText();
    }

}
