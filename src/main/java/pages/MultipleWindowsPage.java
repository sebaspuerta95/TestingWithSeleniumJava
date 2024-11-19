package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage {

    private WebDriver driver;
    private By clickHereButton = By.linkText("Click Here");

    public MultipleWindowsPage (WebDriver driver){
        this.driver = driver;
    }

    public NewWindowPage clickHere(){
        driver.findElement(clickHereButton).click();
        return new NewWindowPage(driver);
    }

    public class NewWindowPage {

        private WebDriver driver;
        private By textNW = By.cssSelector(".example h3");

        public NewWindowPage (WebDriver driver){
            this.driver = driver;
        }

        public String getNWText (){
            return driver.findElement(textNW).getText();
        }

    }

}
