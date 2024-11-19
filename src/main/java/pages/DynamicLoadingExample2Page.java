package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample2Page {

    private WebDriver driver;
    private By startButton2 = By.cssSelector("#start button");
    private By loadedText2 = By.id("finish");


    public DynamicLoadingExample2Page (WebDriver driver){
        this.driver = driver;
    }

    public void clickStartButtonExample2 (){
        driver.findElement(startButton2).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadedText2));
    }

    public String getLoadedText2 (){
        return driver.findElement(loadedText2).getText();
    }

    public boolean isButtonDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(startButton2)));
        return driver.findElement(startButton2).isDisplayed();
    }

}
