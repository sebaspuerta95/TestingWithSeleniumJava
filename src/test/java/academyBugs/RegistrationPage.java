package academyBugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstnameField = By.cssSelector("input[name='ec_account_register_first_name']");
    private By firstnameError = By.id("ec_account_register_first_name_error");
    private By lastnameField = By.cssSelector("input[name='ec_account_register_last_name']");
    private By lastnameError = By.id("ec_account_register_last_name_error");
    private By emailField = By.cssSelector("input[name='ec_account_register_email']");
    private By emailError = By.id("ec_account_register_email_error");
    private By retypeEmailField = By.cssSelector("input[name='ec_account_register_retype_email']");
    private By retypeEmailError = By.id("ec_account_register_email_retype_error");
    private By passwordField = By.cssSelector("input[name='ec_account_register_password']");
    private By passwordError = By.id("ec_account_register_password_error");
    private By retypePasswordField = By.cssSelector("input[name='ec_account_register_password_retype']");
    private By retypePasswordError = By.id("ec_account_register_password_retype_error");
    private By registerButton = By.cssSelector("input[value='REGISTER']");

    public void inputValues(String firstname, String lastname, String email, String retypeEmail,
                            String password, String retypePass){
        driver.findElement(firstnameField).sendKeys(firstname);
        driver.findElement(lastnameField).sendKeys(lastname);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(retypeEmailField).sendKeys(retypeEmail);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(retypePasswordField).sendKeys(retypePass);
    }

    public LoginPage clickRegisterButton (){
        driver.findElement(registerButton).click();
        return new LoginPage(driver);
    }

    public String getFirstnameError (){
        return driver.findElement(firstnameError).getText();
    }

    public String getLastnameError () {
        return driver.findElement(lastnameError).getText();
    }

    public String getEmailError () {
        return driver.findElement(emailError).getText();
    }

    public String getRetypeEmailError () {
        return driver.findElement(retypeEmailError).getText();
    }

    public String getPasswordError () {
        return driver.findElement(passwordError).getText();
    }

    public String getRetypePassError () {
        return driver.findElement(retypePasswordError).getText();
    }

}
