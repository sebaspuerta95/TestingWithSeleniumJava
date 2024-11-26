package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
* This class models the context menu page that is tested in the ContextMenuTests test class (src/test/alerts).
*/ 
public class ContextMenuPage {

    private WebDriver driver;
    private By contextBox = By.id("hot-spot");

    public ContextMenuPage (WebDriver driver){
        this.driver = driver;
    }

    // Actions class is used to hover over the desired web element. 
    public void rightClickOnBox(){
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(contextBox)).perform();
    }

    public String getContextAlertText(){
        return driver.switchTo().alert().getText();
    }

    public void acceptContextAlert(){
        driver.switchTo().alert().accept();
    }

}
