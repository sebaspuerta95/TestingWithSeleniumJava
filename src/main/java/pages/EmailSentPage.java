package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
* This class models the context menu page that is tested in the { @link ForgotPasswordTests } test class (src/test/forgotPassword).
* It is a simple model to get text from the page.
*/ 
public class EmailSentPage {

    private WebDriver driver;
    private By contentArea = By.id("content");

    public EmailSentPage (WebDriver driver){
        this.driver=driver;
    }

    public String getContentText(){
        return driver.findElement(contentArea).getText();
    }

}
