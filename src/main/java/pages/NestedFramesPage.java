package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {

    private WebDriver driver;
    private String topFrame = "frame-top";
    private String leftFrame = "frame-left";
    private String bottomFrame = "frame-bottom";
    private By body = By.tagName("body");

    public NestedFramesPage (WebDriver driver){
        this.driver = driver;
    }

    public String getLeftFrameText(){
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(leftFrame);
        String leftText = getFrameText();
        driver.switchTo().parentFrame(); // Exits from left frame.
        driver.switchTo().parentFrame(); // Exits from top frame.
        return leftText;
    }

    public String getBottomFrameText(){
        driver.switchTo().frame(bottomFrame);
        String bottomText = getFrameText();
        driver.switchTo().parentFrame();
        return bottomText;
    }

    public String getFrameText(){
        return driver.findElement(body).getText();
    }

}
