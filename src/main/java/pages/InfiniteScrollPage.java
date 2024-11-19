package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {

    private WebDriver driver;
    private By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage (WebDriver driver){
        this.driver = driver;
    }

    public void scrollToParagraph(int index){
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExecutor = ((JavascriptExecutor)driver);
        // This is a different way of casting, but it does the same.

        while (getNumberOfParagraphsPresent() < index){
            jsExecutor.executeScript(script);
        }
    }

    public int getNumberOfParagraphsPresent(){
        return driver.findElements(textBlocks).size();
    }

}
