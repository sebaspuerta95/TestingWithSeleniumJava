package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
* This class models the scroll that is tested in the JavascriptTests test class (src/test/javascript). 
*/
public class LargeAndDeepDOMPage {

    private WebDriver driver;
    private By largeTable = By.id("large-table");

    public LargeAndDeepDOMPage (WebDriver driver){
        this.driver = driver;
    }

    /**
    * We need to cast the driver as a JavascriptExecutor object (polymorphism) to use the executeScript() method. 
    * executeScript() takes 2 parameters: Javascript code and Web element to apply the code. 
    * arguments[0] works as a placeholder, as we cannot include web elements in Strings.
    */
    public void scrollToTable(){
        WebElement tableElement = driver.findElement(largeTable);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, tableElement);
    }

}
