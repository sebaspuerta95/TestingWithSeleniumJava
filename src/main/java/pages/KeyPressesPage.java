package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {

    private WebDriver driver;
    private By textBar = By.id("target");
    private By resultBar = By.id("result");

    public KeyPressesPage (WebDriver driver){
        this.driver=driver;
    }

    public void enterText (String string){
        driver.findElement(textBar).sendKeys(string);
    }

    public String getResultText(){
        return driver.findElement(resultBar).getText();
    }

}
