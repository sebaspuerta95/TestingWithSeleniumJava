package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
* This class models the human scroll that is tested in the JavascriptTests test class (src/test/javascript). 
*/
public class InfiniteScrollPage {

    private WebDriver driver;
    private By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage (WebDriver driver){
        this.driver = driver;
    }

    /**
    * The method sends human scrolls until the element is visible in the DOM.
    * window.scrollTo() takes 2 arguments: X axis (it's 0 since we don't want horizontal slides), and Y axis (document.body.scrollHeight represents a human scroll).
    * @param index : Represents the number of paragraphs that we want to show up.
    */
    public void scrollToParagraph(int index){
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExecutor = ((JavascriptExecutor)driver); // Polymorphism.

        while (getNumberOfParagraphsPresent() < index){
            jsExecutor.executeScript(script);
        }
    }

    public int getNumberOfParagraphsPresent(){
        return driver.findElements(textBlocks).size();
    }

}
