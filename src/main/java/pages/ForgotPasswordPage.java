package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;
    private By emailBox = By.id("email");
    private By retrieveButton = By.id("form_submit");

    public ForgotPasswordPage(WebDriver driver){
        this.driver=driver;
    }

    private void typeEmail(String email){
        driver.findElement(emailBox).sendKeys(email);
    }

    private EmailSentPage clickRetrieveButton(){
        driver.findElement(retrieveButton).click();
        return new EmailSentPage(driver);
    }

    public EmailSentPage retrievePassword(String email){
        typeEmail(email);
        return clickRetrieveButton();
    }

}
