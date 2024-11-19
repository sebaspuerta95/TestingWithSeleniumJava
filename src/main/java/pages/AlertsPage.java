package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
* This class models the JS alerts page that is tested in the { @JSAlertsTests } test class (src/test/alerts).
*/ 
public class AlertsPage {

    private WebDriver driver;
    private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");
    private By resultBar = By.id("result");

    public AlertsPage (WebDriver driver){
        this.driver = driver;
    }

    public void click_alertButton(){
        driver.findElement(triggerAlertButton).click();
    }

    public void click_confirmButton(){
        driver.findElement(triggerConfirmButton).click();
    }

    public void click_promptButton(){
        driver.findElement(triggerPromptButton).click();
    }

    public void alert_acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void alert_dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void alert_sendText(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public String alert_getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public String getResultText(){
        return driver.findElement(resultBar).getText();
    }

}
