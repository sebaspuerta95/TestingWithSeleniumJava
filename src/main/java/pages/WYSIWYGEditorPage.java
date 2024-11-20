package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
* This class models the context menu page that is tested in the { @FramesTests } test class (src/test/frames). 
*/ 
public class WYSIWYGEditorPage {

    private WebDriver driver;
    private String frameArea = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By increaseInd = By.cssSelector("[title='Increase indent']");

    public WYSIWYGEditorPage (WebDriver driver){
        this.driver = driver;
    }

    // The switchToFrame and switchOutOfFrame methods are very important to enter and exit the frame after each action because we don't know where the next action is going to be performed. 
    // If we do not handle this properly, we might get the NoSuchElementException exception message. 
    private void switchToFrame(){
        driver.switchTo().frame(frameArea);
    }

    private void switchOutOfFrame(){
        driver.switchTo().parentFrame();
    }
    
    public void clearTextArea(){
        switchToFrame();
        driver.findElement(textArea).clear();
        switchOutOfFrame();
    }

    public void writeTextArea(String text){
        switchToFrame();
        driver.findElement(textArea).sendKeys(text);
        switchOutOfFrame();
    }

    public void increaseIndentation(){
        driver.findElement(increaseInd).click();
    }

    public String getFrameText (){
        switchToFrame();
        String text = driver.findElement(textArea).getText();
        switchOutOfFrame();
        return text;
    }

}
