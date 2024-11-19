package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WYSIWYGEditorPage {

    private WebDriver driver;
    private String frameArea = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By increaseInd = By.cssSelector("[title='Increase indent']");

    public WYSIWYGEditorPage (WebDriver driver){
        this.driver = driver;
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

    private void switchToFrame(){
        driver.switchTo().frame(frameArea);
    }

    private void switchOutOfFrame(){
        driver.switchTo().parentFrame();
    }

}
