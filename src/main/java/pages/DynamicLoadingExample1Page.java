package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class DynamicLoadingExample1Page {

    private WebDriver driver;
    private By startButton1 = By.cssSelector("#start button");
    private By loadingIndicator = By.id("loading");
    private By loadedText1 = By.id("finish");

    public DynamicLoadingExample1Page (WebDriver driver){
        this.driver = driver;
    }

    public void clickStartButtonExample1(){
        driver.findElement(startButton1).click();

        // Explicit Wait option.
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));

        // Fluent Wait option.
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .withMessage("The web element wasn't found.");
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
    }

    public String getLoadedText1(){
        return driver.findElement(loadedText1).getText();
    }

}
